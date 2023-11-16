package com.example.datn.Service.Impl;

import com.example.datn.Entity.AnhSanPham;
import com.example.datn.Repository.AnhSanPhamRepository;
import com.example.datn.Service.AnhSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnhSanPhamServiceImpl   implements AnhSanPhamService {
    @Autowired
    AnhSanPhamRepository anhSanPhamRepository;
    @Override
    public AnhSanPham save(AnhSanPham anhSanPham) {
        return anhSanPhamRepository.save(anhSanPham);
    }
}
