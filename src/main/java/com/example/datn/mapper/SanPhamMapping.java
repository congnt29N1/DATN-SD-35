package com.example.datn.mapper;

import com.example.datn.Entity.SanPham;
import com.example.datn.Response.SanPhamDetailResponse;
import lombok.Data;

@Data
public class SanPhamMapping {
//    public  static SanPhamDetailResponse mapEntitytoResponse(SanPham sp){
//        SanPhamDetailResponse sanPhamDetailResponse =  SanPhamDetailResponse.builder()
//                .idSanPham(sp.getIdSanPham())
//                .listAnhSanPham(sp.getListAnhSanPham())
//                .moTaSanPham(sp.getMoTaSanPham())
//                .danhMuc(sp.getDanhMuc())
//                .listChiTietSanPham(sp.getListChiTietSanPham())
//                .thuongHieu(sp.getThuongHieu())
//                .trangThai(sp.getTrangThai())
//                .tenSanPham(sp.getTenSanPham())
//                .maSanPham(sp.getMaSanPham())
//                .build();
//        return sanPhamDetailResponse;
//    }
    public  static SanPhamDetailResponse mapEntitytoResponse(SanPham sp){
        SanPhamDetailResponse sanPhamDetailResponse =  SanPhamDetailResponse.builder()
                .idSanPham(sp.getIdSanPham())
                .listAnhSanPham(sp.getListAnhSanPham())
                .moTaSanPham(sp.getMoTaSanPham())
                .danhMuc(sp.getDanhMuc())
                .listChiTietSanPham(sp.getListChiTietSanPham())
                .trangThai(sp.getTrangThai())
                .tenSanPham(sp.getTenSanPham())
                .maSanPham(sp.getMaSanPham())
                .build();
        return sanPhamDetailResponse;
    }

}
