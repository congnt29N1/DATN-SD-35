package com.example.datn.Service;

import com.example.datn.Entity.Veao;
import com.example.datn.Exception.VeAoNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VeAoService {
    List<Veao> getAllVeAo();
    public static final int MATERIALS_PER_PAGE = 4;

    public List<Veao> getAllPaginationVeAo();
    public Page<Veao> listByPage(int pageNumber, String sortField, String sortDir, String keyword);

    public Veao save(Veao veao);

    public Veao get(Integer id) throws VeAoNotFoundException, Exception;

    public boolean checkUnique(Integer id, String ten);

    public void updateVeAoEnabledStatus(Integer id, boolean enabled);
}
