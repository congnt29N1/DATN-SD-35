package com.example.datn.Service.impl;


import com.example.datn.Entity.GioHang;
import com.example.datn.Repository.GioHangRepository;
import com.example.datn.Request.GioHangRequest;
import com.example.datn.Response.GiohangResponse;
import com.example.datn.Service.GioHangService;
import com.example.datn.mapper.GioHangMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    GioHangRepository gioHangRepository;
    @Override
    public GiohangResponse addGioHang(GioHangRequest gioHangRequest) {
        GioHang gioHang = GioHangMapping.mapRequestToEntity(gioHangRequest);
        GiohangResponse gioHangResponse = GioHangMapping.mapEntitytoResponse(gioHangRepository.save(gioHang));
        return gioHangResponse;
    }

    @Override
    public GiohangResponse findGioHang(Integer idKhachHang) {
        //find khachHang 1
        GioHang gioHang = gioHangRepository.findGioHang(1);
        GiohangResponse gioHangResponse = GioHangMapping.mapEntitytoResponse(gioHang);
        return gioHangResponse;
    }
}
