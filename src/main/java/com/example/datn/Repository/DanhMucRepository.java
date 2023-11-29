package com.example.datn.Repository;

import com.example.datn.Entity.DanhMuc;
import com.example.datn.Entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc,Integer> {
    @Query("UPDATE DanhMuc dm SET dm.enabled = ?2 WHERE dm.id = ?1")
    @Modifying
    void updateEnabledStatus(Integer id, boolean enabled);


    @Query("SELECT dm FROM DanhMuc dm WHERE UPPER(CONCAT(dm.id, ' ', dm.ten)) LIKE %?1%")
    public Page<DanhMuc> findAll(String keyword, Pageable pageable);

    public DanhMuc findByTen(String ten);


}
