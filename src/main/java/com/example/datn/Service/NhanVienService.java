package com.example.datn.Service;

import com.example.datn.Entity.ChucVu;
import com.example.datn.Entity.NhanVien;
import com.example.datn.Exception.NhanVienNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {
    NhanVien findByEmail(String email);
    NhanVien findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existSByEmail(String email);

    public static final int USERS_PER_PAGE = 4;

    public NhanVien getByEmail(String email);

    public List<NhanVien> listAll();

    public Page<NhanVien> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public List<ChucVu> listChucVu();

    public NhanVien save(NhanVien nhanVien);

    public NhanVien nhanVienUpdateAccount(NhanVien nhanVienInForm);

    public void encodePassword(NhanVien nhanVien);

    public boolean isEmailUnique(Integer id ,String email);


    public NhanVien get(Integer id) throws NhanVienNotFoundException;

    public void delete(Integer id) throws NhanVienNotFoundException;

    public  void updateNhanVienEnabledStatus(Integer id, boolean enabled);
}
