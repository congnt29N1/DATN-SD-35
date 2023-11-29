package com.example.datn.Service;

import com.example.datn.Request.PhanHoiRequest;
import com.example.datn.Response.PhanHoiResponse;

import java.util.List;

public interface PhanHoiService {

    List<PhanHoiResponse> findAll(Integer idSanPham);

    boolean checkPhanHoi(Integer idKhachHang, Integer idSanPham);

    PhanHoiResponse addPhanHoi(PhanHoiRequest phanHoiRequest);

    Long countPH(Integer idKhachHang, Integer idChiTietSanPham);
    Long countHDCT(Integer idKhachHang, Integer idChiTietSanPham);

}
