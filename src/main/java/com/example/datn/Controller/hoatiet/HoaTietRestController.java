package com.example.datn.Controller.hoatiet;

import com.example.datn.Entity.HoaTiet;
import com.example.datn.Exception.CustomException.HoaTietNotFoundException;
import com.example.datn.Export.HoaTietCsvExporter;
import com.example.datn.Export.HoaTietExcelExporter;
import com.example.datn.Service.DanhmucService;
import com.example.datn.Service.HoaTietService;
import com.example.datn.Service.Impl.HoaTietServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class HoaTietRestController {
    @Autowired
    HoaTietService service;
    @Autowired
    HttpServletRequest  request;
    @PostMapping("/admin/degins/check_name")
    public String checkDuplicateTen(@Param("idHoaTiet") Integer id ,@Param("tenHoaTiet") String ten) {
        return service.checkUnique(id, ten) ? "OK" : "Duplicated";}


}
