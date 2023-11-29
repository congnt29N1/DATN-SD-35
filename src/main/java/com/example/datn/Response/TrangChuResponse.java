package com.example.datn.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TrangChuResponse {
    private List<SanPhamDetailResponse> listSPbanChay;
    private List<SanPhamDetailResponse> listSPmoiNhat;
    private List<SanPhamDetailResponse> listSPNoiBat;
}
