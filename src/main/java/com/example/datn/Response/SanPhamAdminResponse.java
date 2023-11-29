package com.example.datn.Response;

import com.example.datn.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamAdminResponse {
    private Integer idChiTietSanPham;
    private String maChiTietSanPham;
    private SanPham sanPham;
    private KhuyenMai khuyenMai;
    private MauSac mauSac;
    private Double giaSanPham;
    private Integer soLuong;
    private VatLieu vatLieu;
}
