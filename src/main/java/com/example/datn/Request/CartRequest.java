package com.example.datn.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRequest {
    Integer idChiTietSanPham;
    Integer soLuong;
    Integer idKhachHang;
    Double giaSanPham;
}
