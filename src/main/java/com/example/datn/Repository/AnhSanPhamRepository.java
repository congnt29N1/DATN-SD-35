package com.example.datn.Repository;


import com.example.datn.Entity.AnhSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnhSanPhamRepository extends JpaRepository<AnhSanPham,Integer> {
}
