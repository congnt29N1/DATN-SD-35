package com.example.datn.service;

import com.example.datn.Entity.ChucVu;
import com.example.datn.Entity.NhanVien;
import com.example.datn.exception.NhanVienNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {
    NhanVien findByEmail(String email);
    NhanVien finByUserName(String userName);
    boolean existByUserName(String userName);
    boolean existByEmail(String email);

    public static final int USER_PER_PAGE = 8;

    public NhanVien getByEmail(String email);
    public List<NhanVien> listAll();
    public Page<NhanVien> listByPage(int pageNumber,String sortField,String sortDir, String keyword);
    public List<ChucVu> listChucVu();
    public NhanVien save(NhanVien nhanVien);
    public NhanVien nhanVienUpdateAccount(NhanVien nhanVien);
    public void encodePassword(NhanVien nhanVien);
    public boolean isEmailUnique(Integer id,String email);
    public NhanVien get(Integer id) throws NhanVienNotFoundException;
    public void delete(Integer id) throws NhanVienNotFoundException;
    public void updateNhanVienEnabledStatus(Integer id,boolean enabled);
}
