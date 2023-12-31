package com.example.datn.Service;

import com.example.datn.Entity.KieuTui;
import com.example.datn.Exception.kieuTuiNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KieuTuiService {
    List<KieuTui> getAllKieuTui();
    public static final int MATERIALS_PER_PAGE = 4;

    public List<KieuTui> getAllPaginationKieuTui();
    public Page<KieuTui> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public KieuTui save(KieuTui kieuTui);

    public KieuTui get(Integer id) throws kieuTuiNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

    public void updateKieuTuiEnabledStatus(Integer id, boolean enabled);
}
