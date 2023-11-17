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
    private List<MauSac>listmauSac;
    private List<KichCo> listKichCo;
    private List<KieuDet>listkieuDet;
    private List<ChatLieu>listchatLieu;
    private List<CauTrucKhuy>listcauTrucKhuy;
}
