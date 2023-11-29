package com.example.datn.Service;

import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.Seri;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SeriService {
    Seri save(Seri seri);
    List<Seri> saveMany(List<Seri> seri);
    Seri get(Integer id);
    Page<Seri> searchSeri(int pageNumber,int pageSize, String keyword);

    Integer countSeri (Integer idChiTietSanPham);
    List<Seri> findByChiTietSanPham(ChiTietSanPham chiTietSanPham, Integer soLuong);

    void updateSoLuongAdmin(int idHDCT, int soLuongCapNhat);
    List<Seri> findByHoaDonChiTiet (Integer idhoaDonChiTiet);
}
