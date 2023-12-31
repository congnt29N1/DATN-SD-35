package com.example.datn.Service;

import com.example.datn.Entity.LopLot;
import com.example.datn.Exception.LopLotNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LopLotService {
    List<LopLot> getAllLopLot();
    public static final int MATERIALS_PER_PAGE = 4;

    public List<LopLot> getAllPaginationLopLot();
    public Page<LopLot> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public LopLot save(LopLot lopLot);

    public LopLot get(Integer id) throws LopLotNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

    public void updateLopLotEnabledStatus(Integer id, boolean enabled);
}
