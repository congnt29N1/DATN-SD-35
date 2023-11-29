package com.example.datn.mapper;

import com.example.datn.Entity.GioHang;
import com.example.datn.Entity.HoaDonChiTiet;
import com.example.datn.Request.GioHangRequest;
import com.example.datn.Response.GiohangResponse;
import com.example.datn.Response.HoaDonChiTietResponse;
import lombok.Data;

@Data
public class HoaDonChiTietMapping {

    public  static HoaDonChiTietResponse mapEntitytoResponse(HoaDonChiTiet hoaDonChiTiet){
        HoaDonChiTietResponse hoaDonChiTietResponse =  HoaDonChiTietResponse.builder()
                .idHoaDonChiTiet(hoaDonChiTiet.getIdHoaDonChiTiet())
                .chiTietSanPham(hoaDonChiTiet.getChiTietSanPham())
                .donHang(hoaDonChiTiet.getDonHang())
                .giaBan(hoaDonChiTiet.getGiaBan())
                .soLuong(hoaDonChiTiet.getSoLuong())

                .build();
        return hoaDonChiTietResponse;
    }



}
