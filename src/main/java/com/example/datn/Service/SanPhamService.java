package com.example.datn.Service;


import com.example.datn.Entity.*;
import com.example.datn.Exception.SanPhamNotFountException;
import com.example.datn.Request.TimKiemRequest;
import com.example.datn.Response.ChiTietSanPhamResponse;
import com.example.datn.Response.SanPhamDetailResponse;
import com.example.datn.Response.TimKiemResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface SanPhamService {

    public static final int PRODUCT_PER_PAGE = 5;

    Set<TimKiemResponse> getSanPhamByCondition(TimKiemRequest timKiemRequest);

    List<SanPhamDetailResponse> getSPnew();
    List<SanPhamDetailResponse> getSPFeature();

    List<SanPhamDetailResponse> getSPchay();

    SanPhamDetailResponse getDetailSanPhamById(Integer sanPhamId);

    List<ChiTietSanPhamResponse> getSPchayKM(Integer idChiTietSanPham);

//    public Page<SanPham> getPageSanPham(int pageNumber);

    public List<SanPham> listAll();

    public SanPham save(SanPham sanPham);

//    public boolean checkUnique(String ten);

    public SanPham get(Integer id) throws SanPhamNotFountException;

    public Page<SanPham> listByPage(int pageNumber,String sortField, String sortDir, String keyword);


    List<SanPham> getSPCungTH(ThuongHieu thuongHieu);

    public boolean checkUniqueTenAndMa(String ten, String ma);

    public boolean checkUniqueTenMaId(String ten, String ma, Integer id);
}
