package com.example.datn.Response;

import com.example.datn.Entity.KichCo;
import com.example.datn.Entity.KieuDet;
import com.example.datn.Entity.ChatLieu;

import com.example.datn.Entity.MauSac;
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
    private List<MauSac>listmauSac;
    private List<KichCo> listKichCo;
    private List<KieuDet>listkieuDet;
    private List<ChatLieu>listchatLieu;
}
