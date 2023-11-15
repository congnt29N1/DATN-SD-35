package com.example.datn.Repository;

import com.example.datn.Entity.HoaTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaTietRespository extends JpaRepository<HoaTiet, Integer> {



}
