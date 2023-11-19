package com.example.datn.Response;


import com.example.datn.Entity.CauTrucKhuy;
import com.example.datn.Entity.ChatLieu;
import com.example.datn.Entity.DanhMuc;
import com.example.datn.Entity.HoaTiet;
import com.example.datn.Entity.KhuyenMai;
import com.example.datn.Entity.KichCo;
import com.example.datn.Entity.KieuDet;
import com.example.datn.Entity.KieuTui;
import com.example.datn.Entity.LopLot;
import com.example.datn.Entity.MauSac;
import com.example.datn.Entity.VeAo;
import com.example.datn.Entity.XeTa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class TimKiemSettingResponse {
    private List<DanhMuc> listDanhMuc;
    private List<KichCo> listKichCo;
    private List<KhuyenMai> listKhuyenMai;
    private List<MauSac> listMauSac;
    private List<KieuDet> listkieuDet;
    private List<KieuTui> listKieuTui;
    private List<ChatLieu> listchatLieu;
    private List<HoaTiet> listHoaTiet;
    private List<VeAo> listveAo;
    private List<XeTa> listXeTa;
    private List<LopLot> listlopLot;
    private List<CauTrucKhuy> listcauTrucKhuy;

}
