package com.example.datn.Service.Impl;

import com.example.datn.Cache.DiaChiCache;
import com.example.datn.Entity.DiaChi;
import com.example.datn.Entity.KhachHang;
import com.example.datn.Entity.PasswordResetToken;
import com.example.datn.Exception.CustomException.BadRequestException;
import com.example.datn.GiaoHangNhanhService.DiaChiAPI;
import com.example.datn.Repository.NhanVienRepository;
import com.example.datn.Request.ChangePassRequest;
import com.example.datn.Request.RegisterRequest;
import com.example.datn.Repository.DiaChiRespository;
import com.example.datn.Repository.KhachHangRespository;
import com.example.datn.Repository.PasswordResetTokenRepository;
import com.example.datn.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    KhachHangRespository khachHangRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;
    @Autowired
    DiaChiRespository diaChiRepository;
    @Override
    public ResponseEntity<?> register(RegisterRequest registerRequest) throws Exception {
        KhachHang findKHbyEmail = khachHangRepository.getKhachHangByEmail((registerRequest.getEmail()));
        KhachHang khachHangBysdt = khachHangRepository.getKhachHangBySdt(registerRequest.getSoDienThoai());
        if(registerRequest.getIdTinhThanh() == null || registerRequest.getIdQuanHuyen()== null || registerRequest.getIdPhuongXa() == null){
            throw new BadRequestException("Mời bạn nhập địa chỉ");
        }
        if(registerRequest.getNgaySinh().after(new Date())){
            throw new BadRequestException("Nhập sai ngày sinh");
        }
        if(registerRequest.getPassword().isEmpty()){
            throw new BadRequestException("Password không được trống");
        }
        if(findKHbyEmail !=null){
            throw new BadRequestException("Emai đã tồn tại");
        }
        if(khachHangBysdt != null & khachHangBysdt.getPassword() == null){
            khachHangBysdt.setEmail(registerRequest.getEmail());
            khachHangBysdt.setEnabled(true);
            khachHangBysdt.setGioiTinh(registerRequest.getGioiTinh());
            khachHangBysdt.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            khachHangBysdt.setNgaySinh(registerRequest.getNgaySinh());
            khachHangBysdt.setNgaySua(new Date());
            khachHangBysdt.setThoiGianTaoTaiKhoan(new Timestamp(new Date().getTime()));
            KhachHang khachHang1 = khachHangRepository.save(khachHangBysdt);
            DiaChi diaChi = DiaChi.builder()
                    .diaChi(registerRequest.getDiaChi())
                    .idTinhThanh(registerRequest.getIdTinhThanh())
                    .idQuanHuyen(registerRequest.getIdQuanHuyen())
                    .idPhuongXa(registerRequest.getIdPhuongXa())
                    .ghiChu("")
                    .maBuuChinh(123)
                    .khachHang(khachHang1)
                    .trangThaiMacDinh(1)
                    .soDienThoai(registerRequest.getSoDienThoai())
                    .build();
            DiaChi diaChi1 = diaChiRepository.save(diaChi);
            return new ResponseEntity<>(khachHang1, HttpStatus.OK);
        }
        else if(khachHangBysdt !=null){
            throw new BadRequestException("Số điện thoại đã được đăng kí");
        }
        else {
            KhachHang khachHang = KhachHang.builder()
                    .idKhachHang(null)
                    .email(registerRequest.getEmail())
                    .enabled(true)
                    .gioiTinh(registerRequest.getGioiTinh())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .tenKhachHang(registerRequest.getTenKhachHang())
                    .ngaySinh(registerRequest.getNgaySinh())
                    .ngaySua(new Date())
                    .soDienThoai(registerRequest.getSoDienThoai())
                    .thoiGianTaoTaiKhoan(new Timestamp(new Date().getTime()))
                    .build();
            KhachHang khachHang1 = khachHangRepository.save(khachHang);

            DiaChi diaChi = DiaChi.builder()
                    .diaChi(registerRequest.getDiaChi())
                    .idTinhThanh(registerRequest.getIdTinhThanh())
                    .idQuanHuyen(registerRequest.getIdQuanHuyen())
                    .idPhuongXa(registerRequest.getIdPhuongXa())
                    .ghiChu("")
                    .maBuuChinh(123)
                    .khachHang(khachHang1)
                    .trangThaiMacDinh(1)
                    .soDienThoai(registerRequest.getSoDienThoai())
                    .build();
            DiaChi diaChi1 = diaChiRepository.save(diaChi);
            return new ResponseEntity<>(khachHang1, HttpStatus.OK);
        }
    }

    @Override
    public HashMap<Integer, String> getListTP() {
        return DiaChiCache.hashMapTinhThanh;
    }

    @Override
    public HashMap<Integer, String> getListQuan(Integer idTP) throws Exception {
        DiaChiAPI.callGetQuanHuyenAPI(idTP);
        return DiaChiCache.hashMapQuanHuyen.get(idTP);
    }

    @Override
    public HashMap<String, String> getListPhuong(Integer idQH) throws Exception {
        DiaChiAPI.callGetPhuongXaAPI(idQH);
        return DiaChiCache.hashMapPhuongXa.get(idQH);
    }

    @Override
    public ResponseEntity<?> changePass(Principal p, ChangePassRequest changePassRequest) throws Exception {
        if(changePassRequest.getNewPass() == null){
            throw new BadRequestException("Mật khẩu không được để trống");
        }
        if(changePassRequest.getConfirmPass() == null){
            throw new BadRequestException("Mật khẩu không được để trống");
        }
        String email = p.getName();
        KhachHang user = khachHangRepository.getKhachHangByEmail(email);
        boolean f = passwordEncoder.matches(changePassRequest.getOldPass(), user.getPassword());
        if(f){
            if(!changePassRequest.getNewPass().equals(changePassRequest.getConfirmPass())){
                throw new BadRequestException("Xác nhận mật khẩu không khớp");
            }
            else {
                user.setPassword(passwordEncoder.encode(changePassRequest.getNewPass()));
                khachHangRepository.save(user);
                return ResponseEntity.status(HttpStatus.OK).body(khachHangRepository.save(user));
            }
        }else {
            throw new BadRequestException("Mật khẩu không đúng");
        }
    }

    public Optional<KhachHang> getUserByPasswordResetToken(final String token){
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getKhachHang());
    }
    @Override
    public void createPasswordResetTokenForUsser(KhachHang user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token,user);
        passwordResetTokenRepository.save(myToken);
    }
    private boolean isTokenFound(PasswordResetToken passToken){
        return passToken !=null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken){
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
    @Override
    public String validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passwordResetTokenRepository.findByToken(token);
        return !isTokenFound(passToken)?"invalidToken"
                : isTokenExpired(passToken)? "expired"
                :null;
    }

    @Override
    public void changeforgotPass(KhachHang khachHang, String pass) {
        khachHang.setPassword(passwordEncoder.encode(pass));
        khachHangRepository.save(khachHang);
    }
}
