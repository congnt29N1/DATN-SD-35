package com.example.datn.Repository;


import com.example.datn.Entity.DiaChi;
import com.example.datn.Entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DiaChiRepository extends JpaRepository<DiaChi,Integer> {
    public DiaChi findByDiaChi(String diaChi);
    List<DiaChi> findByKhachHang(KhachHang khachHang);

    @Query("SELECT dc FROM DiaChi dc WHERE dc.khachHang.idKhachHang = ?1 and dc.trangThaiMacDinh = 1")
    public DiaChi getDiaChiDefault(Integer idKhachHang);

    @Query("SELECT dc FROM DiaChi dc WHERE dc.khachHang.idKhachHang = ?1")
    List<DiaChi> findByIdKH(Integer idkhachHang);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `diachi` WHERE id_dia_chi = ?1",nativeQuery = true)
    void deleteDC(Integer idDiaChi);

}
