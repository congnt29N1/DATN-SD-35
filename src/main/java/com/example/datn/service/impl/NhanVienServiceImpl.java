package com.example.datn.Service.Impl;

import com.example.datn.Entity.ChucVu;
import com.example.datn.Entity.NhanVien;
import com.example.datn.Repository.NhanVienRepository;
import com.example.datn.exception.NhanVienNotFoundException;
import com.example.datn.repository.ChucVuRepository;
import com.example.datn.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private ChucVuRepository chucVuRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public NhanVien findByEmail(String email) {
        return nhanVienRepository.findNhanVienByEmail(email);
    }

    @Override
    public NhanVien finByUserName(String userName) {
        return nhanVienRepository.findByTen(userName);

    }

    @Override
    public boolean existByUserName(String userName) {
        return nhanVienRepository.existsByTen(userName);
    }

    @Override
    public boolean existByEmail(String email) {
        return nhanVienRepository.existsByEmail(email);

    }

    @Override
    public NhanVien getByEmail(String email) {
        return nhanVienRepository.getNhanVienByEmail(email);

    }

    @Override
    public List<NhanVien> listAll() {
        return (List<NhanVien>) nhanVienRepository.findAll(Sort.by("ten").ascending());
    }

    @Override
    public Page<NhanVien> listByPage(int pageNumber, String sortField, String sortDir, String keyword) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending():sort.descending();
        Pageable pageable = PageRequest.of(pageNumber -1,USER_PER_PAGE, sort);
        if (keyword != null){
            return  nhanVienRepository.findAll(keyword,pageable);
        }
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public List<ChucVu> listChucVu() {
        return chucVuRepository.findAll();
    }

    @Override
    public NhanVien save(NhanVien nhanVien) {
        boolean isUpdatingNhanVien = (nhanVien.getId() != null);

        if(isUpdatingNhanVien){
            NhanVien existingNhanVien = nhanVienRepository.findById(nhanVien.getId()).get();
            if(nhanVien.getMatKhau() == null || nhanVien.getMatKhau().isEmpty()){
                nhanVien.setMatKhau(existingNhanVien.getMatKhau());
            }else {
                encodePassword(nhanVien);
            }

        }else {
            encodePassword(nhanVien);
        }
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien nhanVienUpdateAccount(NhanVien nhanVien) {
        NhanVien nhanVienInDB = nhanVienRepository.findById(nhanVien.getId()).get();
        if (nhanVien.getMatKhau().isEmpty()){
            nhanVienInDB.setMatKhau(nhanVien.getMatKhau());
            encodePassword(nhanVienInDB);
        }

        if(nhanVien.getAnh() != null){
            nhanVienInDB.setAnh((nhanVien.getAnh()));
        }
        nhanVienInDB.setHo(nhanVien.getHo());
        nhanVienInDB.setTen(nhanVien.getTen());
        nhanVienInDB.setDiaChi(nhanVien.getDiaChi());
        nhanVienInDB.setSoDienThoai(nhanVien.getHo());
        return nhanVienRepository.save(nhanVienInDB);
    }

    @Override
    public void encodePassword(NhanVien nhanVien) {
        String encodePassword = passwordEncoder.encode(nhanVien.getMatKhau());
        nhanVien.setMatKhau(encodePassword);
    }

    @Override
    public boolean isEmailUnique(Integer id, String email) {
        NhanVien nhanVien = nhanVienRepository.getNhanVienByEmail(email);
        if(nhanVien == null) return true;
        boolean isCreatingNew = (id == null);
        if (isCreatingNew){
            if(nhanVien != null){
                return false;
            }
        }else {
            if (nhanVien.getId() != id){
                return false;
            }
        }
        return true;
    }

    @Override
    public NhanVien get(Integer id) throws NhanVienNotFoundException {
        try{
            return nhanVienRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new NhanVienNotFoundException("không tìm thấy nhân viên nào có ID:"+id);
        }
    }

    @Override
    public void delete(Integer id) throws NhanVienNotFoundException {
        Long countById = nhanVienRepository.countById(id);
        if (countById == null || countById == 0){
            throw new NhanVienNotFoundException("không tìm thấy nhân viên nào theo ID: "+id);
        }
        nhanVienRepository.deleteById(id);
    }

    @Override
    public void updateNhanVienEnabledStatus(Integer id, boolean enabled) {
        nhanVienRepository.updateEnabledStatus(id,enabled);
    }
}
