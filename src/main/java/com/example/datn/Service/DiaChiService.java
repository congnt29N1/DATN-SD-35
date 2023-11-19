package com.example.datn.Service;

import com.example.datn.Entity.DiaChi;
import com.example.datn.Entity.KhachHang;
import com.example.datn.Request.DiaChiRequest;

import java.util.List;

public interface DiaChiService {
    public com.datn.dongho5s.Response.DiaChiResponse createDiaChi(Integer idKhachHang, DiaChiRequest diaChiRequest) throws Exception;
    public List<DiaChi> getAllDiaChi();
    List<DiaChi> getAllDiaChiByKhachHang(KhachHang khachHang);

    List<com.datn.dongho5s.Response.DiaChiResponse> getDiaChiByKhachHang(Integer idKhachHang) throws Exception;
    com.datn.dongho5s.Response.DiaChiResponse updateDC(Integer idDiachi, DiaChiRequest diaChiRequest) throws Exception;
    com.datn.dongho5s.Response.DiaChiResponse updateDCDefault(Integer idKhachHang, Integer idDiachi) throws Exception;
    void delete(Integer idDiachi) ;

    String getDiaChiCuThe(DiaChiRequest diaChiRequest) throws Exception;
}
