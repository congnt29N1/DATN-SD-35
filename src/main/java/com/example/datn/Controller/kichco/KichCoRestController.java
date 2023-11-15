package com.example.datn.Controller.kichco;

import com.example.datn.Service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class KichCoRestController {
    @Autowired
    KichCoService kichCoService;
    @Autowired
    HttpServletRequest request;

    @PostMapping("/admin/sizes/check_name")
    public String checkDuplicateTen(@Param("id") Integer id , @Param("ten") String ten) {
        return kichCoService.checkUnique(id, ten) ? "OK" : "Duplicated";
    }
}
