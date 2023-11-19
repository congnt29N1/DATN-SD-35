package com.example.datn.Controller.cautruckhuy;

import com.example.datn.Service.CauTrucKhuyService;
import com.example.datn.Service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CauTrucKhuyRestController {
    @Autowired
    CauTrucKhuyService cauTrucKhuyService;
    @Autowired
    HttpServletRequest request;

    @PostMapping("/admin/cautruckhuy/check_name")
    public String checkDuplicateTen(@Param("id") Integer id , @Param("ten") String ten) {
        return cauTrucKhuyService.checkUnique(id, ten) ? "OK" : "Duplicated";
    }
}
