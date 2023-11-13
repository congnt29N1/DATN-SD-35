package com.example.datn.Service;

import com.example.datn.Entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MauSacService {
    List<MauSac> getAllMauSac();

    Page<MauSac> listByPage(int pageNum, String sortField, String sortDir, String keyword);

    void updateMauSacEnabledStatus(Integer id, boolean enabled);

    MauSac save(MauSac mauSac);

    MauSac get(Integer id) throws Exception;
}
