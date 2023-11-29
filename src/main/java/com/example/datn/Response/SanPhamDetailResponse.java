package com.example.datn.Response;

import com.example.datn.Entity.AnhSanPham;
import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.DanhMuc;
import com.example.datn.Entity.ThuongHieu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SanPhamDetailResponse {
    private Integer idSanPham;
    private ThuongHieu thuongHieu;
    private DanhMuc danhMuc;
    private List<AnhSanPham> listAnhSanPham;
    private String tenSanPham;
    private String maSanPham;
    private String moTaSanPham;
    private Double giaSanPham;
    private Integer trangThai;
    private List<ChiTietSanPham> listChiTietSanPham;
}
