package com.example.datn.Service;

import com.example.datn.Request.GioHangRequest;
import com.example.datn.Response.GiohangResponse;

public interface GioHangService {
    GiohangResponse addGioHang(GioHangRequest gioHangRequest);

    GiohangResponse findGioHang(Integer idKhachHang);
}
