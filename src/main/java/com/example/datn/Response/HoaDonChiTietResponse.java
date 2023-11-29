package com.example.datn.Response;

import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.DonHang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HoaDonChiTietResponse {
    private Integer idHoaDonChiTiet;

    private DonHang donHang;

    private ChiTietSanPham chiTietSanPham;

    private Integer soLuong;

    private Double giaBan;
}
