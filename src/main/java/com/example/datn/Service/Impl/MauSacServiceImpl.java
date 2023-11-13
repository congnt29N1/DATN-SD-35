package com.example.datn.Service.Impl;

import com.example.datn.Entity.MauSac;
import com.example.datn.Exception.MauSacNotFoundException;
import com.example.datn.Repository.MauSacRepository;
import com.example.datn.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl implements MauSacService {
    public static final int COLORS_PER_PAGE =10;
    @Autowired
    MauSacRepository mauSacRepository;
    @Override
    public List<MauSac> getAllMauSac() {
        return mauSacRepository.findAll();
    }

    @Override
    public Page<MauSac> listByPage(int pageNum, String sortField, String sorDir, String keword) {
        Sort sort = Sort.by(sortField);
        sort = sorDir.equals("asc")?sort.ascending():sort.descending();
        Pageable pageable = PageRequest.of(pageNum -1,COLORS_PER_PAGE,sort);
        if (keword !=null){
            return mauSacRepository.finAll(keword,pageable);
        }
        return mauSacRepository.finAll(keword,pageable);
    }

    @Override
    public void updateMauSacEnabledStatus(Integer id, boolean enabled) {
        mauSacRepository.updateEnabledStatus(id,enabled);
    }

    @Override
    public MauSac save(MauSac mauSac) {
        return mauSacRepository.save(mauSac);
    }

    @Override
    public MauSac get(Integer id) throws Exception {
        try {
            return mauSacRepository.findById(id).orElseThrow(()->new MauSacNotFoundException("không tìm thấy danh mục nào theo ID"+id));

        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }
}
