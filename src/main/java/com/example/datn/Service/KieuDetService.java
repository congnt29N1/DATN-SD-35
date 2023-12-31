package com.example.datn.Service;

import com.example.datn.Entity.KieuDet;
import com.example.datn.Exception.KieuDetNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KieuDetService {
    List<KieuDet> getAllKieuDet();
    public static final int MATERIALS_PER_PAGE = 4;

    public List<KieuDet> getAllPaginationKieuDet();
    public Page<KieuDet> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public KieuDet save(KieuDet kieuDet);

    public KieuDet get(Integer id) throws KieuDetNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

    public void updateKieuDetEnabledStatus(Integer id, boolean enabled);
}
