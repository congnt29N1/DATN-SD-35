package com.example.datn.Controller.loplot;

import com.example.datn.Service.LopLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@RestController
public class LopLotRestController
{
    @Autowired
    LopLotService lopLotService;
    @Autowired
    HttpServletRequest request;

    @PostMapping("/admin/loplot/check_name")
    public String checkDuplicateTen(@Param("id") Integer id , @Param("ten") String ten) {
        return lopLotService.checkUnique(id, ten) ? "OK" : "Duplicated";
    }
}