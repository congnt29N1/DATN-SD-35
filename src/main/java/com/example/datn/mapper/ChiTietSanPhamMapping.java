package com.example.datn.mapper;

import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Response.ChiTietSanPhamResponse;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChiTietSanPhamMapping {
    public  static ChiTietSanPhamResponse mapEntitytoResponse(ChiTietSanPham sp){
        ChiTietSanPhamResponse chiTietSanPhamResponse =  ChiTietSanPhamResponse.builder()
                .idChiTietSanPham(sp.getIdChiTietSanPham())
                .sanPham(sp.getSanPham())
                .khuyenMai(sp.getKhuyenMai())
                .mauSac(sp.getMauSac())
                .kichCo(sp.getKichCo())
                .hoaTiet(sp.getHoaTiet())
                .xeTa(sp.getXeTa())
                .kieuDet(sp.getKieuDet())
                .kieuTui(sp.getKieuTui())
                .veAo(sp.getVeAo())
                .cauTrucKhuy(sp.getCauTrucKhuy())
                .lopLot(sp.getLopLot())
                .chatLieu(sp.getChatLieu())
                .trangThai(sp.getTrangThai())
                .giaSanPham(sp.getGiaSanPham())
                .soLuong(sp.getSoLuong())
                .listPhanHoi(sp.getListPhanHoi())
                .build();
        return chiTietSanPhamResponse;
    }
}
