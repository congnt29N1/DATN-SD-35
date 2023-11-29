package com.example.datn.GiaoHangNhanhService.Request;

import com.example.datn.Entity.ChiTietSanPham;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChiTietItemRequestGHN {
    private ChiTietSanPham ctsp;
    private String name;
    private Integer soLuong;
    private Double giaBan;
}
