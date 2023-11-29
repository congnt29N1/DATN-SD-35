package com.example.datn.Service;

import com.example.datn.Entity.ThuongHieu;
import com.example.datn.Exception.ThuongHieuNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ThuongHieuService {
    public static final int BRANDS_PER_PAGE = 4;

    List<ThuongHieu> getAllThuongHieu();

    public Page<ThuongHieu> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public ThuongHieu save(ThuongHieu thuongHieu);

    public ThuongHieu get(Integer id) throws ThuongHieuNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

    public void updateThuongHieuEnabledStatus(Integer id, boolean enabled);

    public List<ThuongHieu> layDanhSachTenThuongHieu();
}
