package com.example.datn.Service.Impl;

import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.DonHang;
import com.example.datn.Entity.HoaDonChiTiet;
import com.example.datn.Repository.ChiTietSanPhamRepository;
import com.example.datn.Repository.HoaDonChiTietRepository;
import com.example.datn.Request.HoaDonChiTietRequest;
import com.example.datn.Service.ChiTietSanPhamService;
import com.example.datn.Service.DonHangService;
import com.example.datn.Service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    DonHangService donHangService;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;


    @Override
    public HoaDonChiTiet save(HoaDonChiTiet hdct) {
        return hoaDonChiTietRepository.save(hdct);
}

    @Override
    public List<HoaDonChiTiet> convertToListHoaDonChiTiet(List<HoaDonChiTietRequest> list, Integer idDonHang) {
        List<HoaDonChiTiet> result = new ArrayList<>();

        list.forEach( item -> {
            Integer chietKhau =  null;
            ChiTietSanPham ctsp = chiTietSanPhamService.getChiTietSanPhamById(item.getIdChiTietSanPham());
            if(ctsp.getKhuyenMai() == null || ctsp.getKhuyenMai().isEnabled() == false){
                chietKhau = null;
            }else {
                chietKhau = ctsp.getKhuyenMai().getChietKhau();
            }
            HoaDonChiTiet hdct = HoaDonChiTiet.builder()
                    .donHang(donHangService.getById(idDonHang))
                    .chiTietSanPham(ctsp)
                    .soLuong(item.getSoLuong())
                    .chietKhau(chietKhau)
                    .build();
            if(chietKhau == null){
                hdct.setGiaBan(ctsp.getGiaSanPham());
            }else {
                hdct.setGiaBan(ctsp.getGiaSanPham() - ctsp.getGiaSanPham()*chietKhau/100);
            }
            result.add(hdct);
                });
        return result;
    }

    @Override
    public List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> listHDCT) {
        return hoaDonChiTietRepository.saveAll(listHDCT);
    }

    @Override
    public Double getTongGia(List<HoaDonChiTietRequest> list) {
        Double result = 0D;
        for(int i =0; i<list.size(); i++){
            Double giaBan = 0.0;
            ChiTietSanPham ctsp = chiTietSanPhamRepository.findByIdChiTietSanPham(list.get(i).getIdChiTietSanPham());
            if(ctsp.getKhuyenMai()!=null && ctsp.getKhuyenMai().isEnabled()){
                giaBan = ctsp.getGiaSanPham()- ctsp.getGiaSanPham()*ctsp.getKhuyenMai().getChietKhau()/100;
            }else {
                giaBan = ctsp.getGiaSanPham();
            }
            result += list.get(i).getSoLuong() * giaBan;
        }
        return result;
    }

    @Override
    public List<HoaDonChiTiet> getByIdDonHang(int id) {
        return hoaDonChiTietRepository.findHDCTBYIdDonHang(id);
    }

    @Override
    public List<HoaDonChiTiet> getByHoaDonId(DonHang donHang) {
        return hoaDonChiTietRepository.findByDonHan(donHang);
    }

    @Override
    public List<HoaDonChiTiet> getHDCTByMaDonHang(String maDonHang) {
        List<HoaDonChiTiet> hoaDonChiTietPage = hoaDonChiTietRepository.findByMaDonHang(maDonHang);
        return hoaDonChiTietPage;
    }

    @Override
    public HoaDonChiTiet findHoaDonChiTietById(int id) {
        return hoaDonChiTietRepository.findByIdHoaDonChiTiet(id);
    }


}
