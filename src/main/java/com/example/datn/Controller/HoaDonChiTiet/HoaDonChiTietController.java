package com.example.datn.Controller.HoaDonChiTiet;

import com.example.datn.Cache.DiaChiCache;
import com.example.datn.Entity.DonHang;
import com.example.datn.Entity.HoaDonChiTiet;
import com.example.datn.Export.HoaDonPdf;
import com.example.datn.GiaoHangNhanhService.DiaChiAPI;
import com.example.datn.Service.DonHangService;
import com.example.datn.Service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/admin/hoa-don-chi-tiet")
@Controller
public class HoaDonChiTietController {
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private DonHangService donHangService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/search/{id}")
    public String getByIdDonHang(
            @PathVariable("id") int id,
            Model model,
            HttpSession session
    ) {
       session = request.getSession();
        if(session.getAttribute("admin") == null ){
            return "redirect:/login-admin" ;
        }
        List<HoaDonChiTiet> lst = hoaDonChiTietService.getByIdDonHang(id);
        Double tongTien = donHangService.tongTien(id);

        DonHang donHang = donHangService.findById(id);

        model.addAttribute("donHang", donHang);
        model.addAttribute("diaChiCache", new DiaChiCache());
        model.addAttribute("diaChiAPI", new DiaChiAPI());

        model.addAttribute("lstHDCT", lst);
        model.addAttribute("tongTien", donHang.getTongTien());

        session.setAttribute("donHang", donHang);

        return "admin/hoadonchitiet/hoadonchitiet";
    }

    @GetMapping("/export")
    public void exportHoaDon(
            HttpServletResponse response,
            Model model,
            HttpSession session
    ) throws Exception {

        DonHang donHang = (DonHang) session.getAttribute("donHang");

        List<HoaDonChiTiet> lst = hoaDonChiTietService.getByIdDonHang(donHang.getIdDonHang());

        HoaDonPdf hoaDonPdf = new HoaDonPdf();
        hoaDonPdf.exportToPDF(response, lst, donHang);
    }
}
