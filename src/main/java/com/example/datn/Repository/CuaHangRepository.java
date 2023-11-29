package com.example.datn.Repository;


import com.example.datn.Entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang,Integer> {
}
