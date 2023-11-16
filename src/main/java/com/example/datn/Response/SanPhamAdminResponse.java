package com.example.datn.Response;

import com.example.datn.Entity.ChatLieu;
import com.example.datn.Entity.KhuyenMai;
import com.example.datn.Entity.MauSac;
import com.example.datn.Entity.SanPham;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
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
    private ChatLieu chatLieu;
}
