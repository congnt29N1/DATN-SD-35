package com.example.datn.Response;

import com.example.datn.Entity.AnhSanPham;
import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.DanhMuc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SanPhamDetailResponse {
    private Integer idSanPham;
    private DanhMuc danhMuc;
    private List<AnhSanPham> listAnhSanPham;
    private String tenSanPham;
    private String maSanPham;
    private String moTaSanPham;
    private Double giaSanPham;
    private Integer trangThai;
    private List<ChiTietSanPham> listChiTietSanPham;
}
