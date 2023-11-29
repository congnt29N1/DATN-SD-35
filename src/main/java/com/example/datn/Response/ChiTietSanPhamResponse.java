package com.example.datn.Response;

import com.example.datn.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSanPhamResponse {
//    private Integer idChiTietSanPham;
//
//    private SanPham sanPham;
//
//    private DayDeo dayDeo;
//
//    private KhuyenMai khuyenMai;
//
//    private MauSac mauSac;
//
//    private VatLieu vatLieu;
//
//    private KichCo kichCo;
//
//    private Double chieuDaiDayDeo;
//
//    private Double duongKinhMatDongHo;
//
//    private Double doDayMatDongHo;
//
//    private Integer doChiuNuoc;
//
//    private Integer trangThai;
//
//    private Double giaSanPham;
//
//    private Integer soLuong;
//    List<PhanHoi> listPhanHoi;
    private Integer idChiTietSanPham;
    private KhuyenMai khuyenMai;
    private SanPham sanPham;
    private MauSac mauSac;
    private KichCo kichCo;
    private XeTa xeTa;
    private KieuTui kieuTui;
    private VeAo veAo;
    private KieuDet kieuDet;
    private HoaTiet hoaTiet;
    private CauTrucKhuy cauTrucKhuy;
    private LopLot lopLot;
    private ChatLieu chatLieu;
    private Integer trangThai;
    private Double giaSanPham;
    private Integer soLuong;
    private String soMiPhuHop;
    private String giayPhuHop;
    List<PhanHoi> listPhanHoi;
}
