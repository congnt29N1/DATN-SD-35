package com.example.datn.Response;


import com.example.datn.Entity.DanhMuc;
import com.example.datn.Entity.KichCo;

import com.example.datn.Entity.KichCo;
import com.example.datn.Entity.KieuDet;
import com.example.datn.Entity.ChatLieu;

import com.example.datn.Entity.MauSac;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
    private List<MauSac> listMauSac;
    private List<MauSac>listmauSac;
    private List<KichCo> listKichCo;
    private List<KieuDet>listkieuDet;
    private List<ChatLieu>listchatLieu;

}
