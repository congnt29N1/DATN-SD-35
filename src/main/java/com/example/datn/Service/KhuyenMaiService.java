package com.example.datn.Service;

import com.example.datn.Entity.DanhMuc;
import com.example.datn.Entity.KhuyenMai;
import com.example.datn.Exception.DanhMucNotFoundException;
import com.example.datn.Exception.KhuyenMaiNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhuyenMaiService {

    public static final int DISCOUNT_PER_PAGE = 4;

    List<KhuyenMai> listAll();

    public Page<KhuyenMai> listByPage(int pageNumber, String sortField, String sortDir, String keyword);


    public KhuyenMai save(KhuyenMai khuyenMai);

    public KhuyenMai get(Integer id) throws KhuyenMaiNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten, String ma);

//    boolean checkUniqueMa(Integer id, String ma);
    public List<KhuyenMai> getExpiredKhuyenMai ();

}
