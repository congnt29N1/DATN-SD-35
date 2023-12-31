package com.example.datn.Repository;


import com.example.datn.Entity.ChiTietGioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang,Integer> {
    @Query("select ctgh from ChiTietGioHang ctgh where ctgh.gioHang.khachHang.idKhachHang = ?1")
    List<ChiTietGioHang> giohangChiTiet(Integer idKhachhang);

    @Query("select ctgh from ChiTietGioHang ctgh where ctgh.chiTietSanPham.idChiTietSanPham = ?1 and ctgh.gioHang.khachHang.idKhachHang = ?2")
    ChiTietGioHang findChiTietGioHangByCTSP(Integer idChiTietSanPham, Integer idKhachHang);

    @Query("select ctgh from ChiTietGioHang ctgh where ctgh.chiTietSanPham.idChiTietSanPham = ?1 and ctgh.soLuongSanPham = ?2 and ctgh.gioHang.khachHang.idKhachHang = ?3")
    ChiTietGioHang findChiTietGioHangByCTSPVaKhachHang(Integer idChiTietSanPham ,Integer soLuong, Integer idKhachHang);

}
