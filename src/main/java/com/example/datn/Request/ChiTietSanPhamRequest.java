package com.example.datn.Request;

import com.example.datn.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSanPhamRequest {
    private Integer idChiTietSanPham;

    private SanPham sanPham;

    private DayDeo dayDeo;

    private KhuyenMai khuyenMai;

    private MauSac mauSac;

    private VatLieu vatLieu;

    private KichCo kichCo;

    private Double chieuDaiDayDeo;

    private Double duongKinhMatDongHo;

    private Double doDayMatDongHo;

    private Integer doChiuNuoc;

    private Integer trangThai;

    private Double giaSanPham;

    private Integer soLuong;
}
