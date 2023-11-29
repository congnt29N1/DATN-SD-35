package com.example.datn.Repository;

import com.example.datn.Entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,Integer> {

    Optional<ChucVu> findByTenChucVu(String roleName);
}
