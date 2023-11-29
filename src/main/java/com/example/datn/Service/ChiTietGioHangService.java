package com.example.datn.Service;

import com.example.datn.Request.CartRequest;
import com.example.datn.Response.ChiTietGioHangResponse;

import java.util.HashMap;
import java.util.List;

public interface ChiTietGioHangService {

    List<ChiTietGioHangResponse> getChiTietGioHang( Integer idKhachhnag);

    ChiTietGioHangResponse update(Integer soLuong, Integer idChiTietGioHang) throws  Exception;

    void delete(Integer id);
    void deleteAll();
    ChiTietGioHangResponse add(CartRequest cartRequest);

    ChiTietGioHangResponse addToCart(CartRequest cartRequest);

    void removeByCTSPAndKhachHang (Integer idKhachHang , HashMap<Integer,Integer> idChiTietSanPhams);
}
