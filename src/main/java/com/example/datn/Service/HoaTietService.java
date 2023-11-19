package com.example.datn.Service;

import com.example.datn.Entity.HoaTiet;
import com.example.datn.Exception.CustomException.HoaTietNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HoaTietService {
    List<HoaTiet> getAllHoaTiet();

    public static final int MATERIALS_PER_PAGE = 4;
    public  List<HoaTiet> getAllPaginationHoaTiet();
    public Page<HoaTiet> listByPage(int  pageNumber, String sortField, String sortDir,  String keyword);
    public HoaTiet save(HoaTiet hoaTiet);
    public HoaTiet get(Integer id) throws HoaTietNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

    public void updateHoaTietEnabledStatus(Integer id, boolean enabled);

}
