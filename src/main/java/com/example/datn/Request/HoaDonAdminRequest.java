package com.example.datn.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class HoaDonAdminRequest {
    String maHoaDon;
    String sdt;
    String tenKhachHang;
    String ngayTao;
//    Double tongTien;
//    Double giamGia;
//    int idHoaDon;
//    Double tongTienDonHang;
}
