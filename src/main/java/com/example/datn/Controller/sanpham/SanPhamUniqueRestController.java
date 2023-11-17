package com.example.datn.Controller.sanpham;

import com.example.datn.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SanPhamUniqueRestController {
    @Autowired
    private SanPhamService service;
    @Autowired
    HttpServletRequest request;

    @PostMapping("/admin/products/check_name_and_code")
    public String checkDuplicateTenAndMa(@Param("ten") String ten, @Param("ma") String ma) {
        return service.checkUniqueTenAndMa(ten, ma) ? "OK" : "Duplicated";
    }

    @PostMapping("/admin/products/check_name_code_id")
    public String checkDuplicateTenMaId(@Param("ten") String ten, @Param("ma") String ma, @Param("id") Integer id) {
        return service.checkUniqueTenMaId(ten, ma, id) ? "OK" : "Duplicated";
    }

}