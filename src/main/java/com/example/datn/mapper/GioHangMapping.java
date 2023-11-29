package com.example.datn.mapper;

import com.example.datn.Entity.GioHang;
import com.example.datn.Request.GioHangRequest;
import com.example.datn.Response.GiohangResponse;
import lombok.Data;

@Data
public class GioHangMapping {

    public  static GiohangResponse mapEntitytoResponse(GioHang gioHang){
        GiohangResponse gioHangResponse =  GiohangResponse.builder()
                .idGioHang(gioHang.getIdGioHang())
                .khachHang(gioHang.getKhachHang())
                .ngayTaoGioHang(gioHang.getNgayTaoGioHang())
                .trangThaiGioHang(gioHang.getTrangThaiGioHang())
                .thoiGianCapNhapGioHang(gioHang.getThoiGianCapNhapGioHang())
                .ghiChu(gioHang.getGhiChu())
                .build();
        return gioHangResponse;
    }


    public  static GioHang mapRequestToEntity(GioHangRequest gioHangRequest){
        GioHang gioHang =  GioHang.builder()
                .idGioHang(gioHangRequest.getIdGioHang())
                .khachHang(gioHangRequest.getKhachHang())
                .ngayTaoGioHang(gioHangRequest.getNgayTaoGioHang())
                .trangThaiGioHang(gioHangRequest.getTrangThaiGioHang())
                .thoiGianCapNhapGioHang(gioHangRequest.getThoiGianCapNhapGioHang())
                .ghiChu(gioHangRequest.getGhiChu())
                .build();
        return gioHang;
    }
}
