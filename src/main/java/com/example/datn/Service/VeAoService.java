package com.example.datn.Service;

import com.example.datn.Entity.VeAo;
import com.example.datn.Exception.VeAoNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VeAoService {
    List<VeAo> getAllVeAo();
    public static final int MATERIALS_PER_PAGE = 4;

    public List<VeAo> getAllPaginationVeAo();
    public Page<VeAo> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public VeAo save(VeAo veao);

    public VeAo get(Integer id) throws VeAoNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

    public void updateVeAoEnabledStatus(Integer id, boolean enabled);
}
