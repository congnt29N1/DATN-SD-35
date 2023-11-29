package com.example.datn.Service;

import com.example.datn.Entity.DanhMuc;
import com.example.datn.Exception.DanhMucNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DanhmucService {
    List<DanhMuc> listAll();

    public Page<DanhMuc> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public void updateDanhMucEnabledStatus(Integer id, boolean enabled);

    public DanhMuc save(DanhMuc danhMuc);

    public DanhMuc get(Integer id) throws DanhMucNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

}
