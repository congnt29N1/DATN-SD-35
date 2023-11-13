package com.example.datn.Controller.danhmuc;

import com.example.datn.Service.DanhmucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DanhMucRestController {
    @Autowired
    DanhmucService service;
    @Autowired
    HttpServletRequest request;

    @PostMapping("/admin/categories/check_name")
    public String checkDuplicateTen(@Param("id") Integer id ,@Param("ten") String ten) {
        return service.checkUnique(id, ten) ? "OK" : "Duplicated";
    }

}
