package com.example.datn.Service;

import com.example.datn.Entity.ChucVu;

import java.util.Optional;

public interface ChucVuService {
    Optional<ChucVu> findByTenChucVu(String roleName);
}
