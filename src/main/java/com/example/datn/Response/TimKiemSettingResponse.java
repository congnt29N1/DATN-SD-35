package com.example.datn.Response;

import com.example.datn.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class TimKiemSettingResponse {
    private List<DanhMuc> listDanhMuc;
    private List<DayDeo> listDayDeo;
    private List<KichCo> listKichCo;
    private List<MauSac> listMauSac;
    private List<ThuongHieu> listThuongHieu;
    private List<VatLieu> listVatLieu;
//private List<DanhMuc> listDanhMuc;
//    private List<KichCo> listKichCo;
    private List<KhuyenMai> listKhuyenMai;
//    private List<MauSac> listMauSac;
    private List<KieuDet> listkieuDet;
    private List<ChatLieu> listchatLieu;
    private List<VeAo> listveAo;
    private List<LopLot> listlopLot;
    private List<CauTrucKhuy> listcauTrucKhuy;
}
