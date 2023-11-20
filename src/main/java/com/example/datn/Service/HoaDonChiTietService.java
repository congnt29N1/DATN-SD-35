package com.example.datn.Service;

import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.DonHang;
import com.example.datn.Entity.HoaDonChiTiet;
import com.example.datn.Request.HoaDonChiTietRequest;

import java.util.List;

public interface HoaDonChiTietService {
    HoaDonChiTiet save(HoaDonChiTiet hdct);
    List<HoaDonChiTiet> convertToListHoaDonChiTiet(List<HoaDonChiTietRequest> list, Integer idDonHang);

    List<HoaDonChiTiet> saveAll(List<HoaDonChiTiet> listHDCT);

    Double getTongGia(List<HoaDonChiTietRequest> list);

    List<HoaDonChiTiet> getByIdDonHang(int id);

    List<HoaDonChiTiet> getByHoaDonId(DonHang donHang);

    public List<HoaDonChiTiet> getHDCTByMaDonHang(String maDonHang);


    HoaDonChiTiet findHoaDonChiTietById(int id);
}
