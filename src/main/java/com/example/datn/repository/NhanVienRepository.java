package com.example.datn.Repository;

import com.example.datn.Entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends PagingAndSortingRepository<NhanVien,Integer> {
    public NhanVien findNhanVienByEmail(String email);
    public NhanVien findByTen(String ten);
    boolean existsByEmail(String email);
    boolean existsByTen(String ten);

    @Query("select nv from NhanVien  nv where nv.email = :email")
    public NhanVien getNhanVienByEmail(@Param("email") String email);
    public Long countById(Integer id);

    @Query("select nv from NhanVien nv where upper(concat(nv.id,'',nv.email,'',nv.diaChi,'',nv.soDienThoai,'',nv.ho,'',nv.ten) ) like  %?1%")
    public Page<NhanVien> findAll(String keyword, Pageable pageable);

    @Query("update NhanVien nv set nv.enabled = ?2 where nv.id = ?1")
    @Modifying
    public void updateEnabledStatus(Integer id,boolean enabled);
}
