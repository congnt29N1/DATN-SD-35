package com.example.datn.Response;

import com.example.datn.Entity.CauTrucKhuy;
import com.example.datn.Entity.ChatLieu;
import com.example.datn.Entity.HoaTiet;
import com.example.datn.Entity.KhuyenMai;
import com.example.datn.Entity.KichCo;
import com.example.datn.Entity.KieuDet;
import com.example.datn.Entity.KieuTui;
import com.example.datn.Entity.LopLot;
import com.example.datn.Entity.MauSac;
import com.example.datn.Entity.PhanHoi;
import com.example.datn.Entity.SanPham;
import com.example.datn.Entity.VeAo;
import com.example.datn.Entity.XeTa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSanPhamResponse {
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
