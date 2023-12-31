package com.example.datn.Response;

import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.GioHang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietGioHangResponse {
    private Integer idChiTietGioHang;

    private GioHang gioHang;

    private ChiTietSanPham chiTietSanPham;

    private Integer soLuongSanPham;

    private Double giaBan;

    private Date ngayTao;

    private String ghiChu;
}
