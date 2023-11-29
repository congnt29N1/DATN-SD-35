package com.example.datn.Service.impl;

import com.example.datn.Entity.ChucVu;
import com.example.datn.Repository.ChucVuRepository;
import com.example.datn.Service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;
    @Override
    public Optional<ChucVu> findByTenChucVu(String roleName) {
        return chucVuRepository.findByTenChucVu(roleName);
    }
}
