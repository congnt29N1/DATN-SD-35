package com.example.datn.Controller.chitietsanpham;

import com.example.datn.Entity.CauTrucKhuy;
import com.example.datn.Entity.ChatLieu;
import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.KhuyenMai;
import com.example.datn.Entity.KichCo;
import com.example.datn.Entity.MauSac;
import com.example.datn.Entity.SanPham;
import com.example.datn.Exception.ChiTietSanPhamNotFountException;
import com.example.datn.Service.CauTrucKhuyService;
import com.example.datn.Service.ChatLieuService;
import com.example.datn.Service.ChiTietSanPhamService;
import com.example.datn.Service.KhuyenMaiService;
import com.example.datn.Service.KichCoService;
import com.example.datn.Service.MauSacService;
import com.example.datn.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private ChatLieuService chatLieuService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private CauTrucKhuyService cauTrucKhuyService;
    @Autowired
    private KhuyenMaiService khuyenMaiService;
    @Autowired
    private KichCoService kichCoService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/admin/productDetails")
    public String listFirstPage(Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("admin") == null ){
            return "redirect:/login-admin" ;
        }
        return listByPage(1,model,"maChiTietSanPham","asc",null,null);
    }
    @GetMapping("/admin/productDetails/page/{pageNum}")
    private String listByPage(@PathVariable(name = "pageNum") int pageNum, Model model,
                              @Param("sortField") String sortField, @Param("sortDir") String sortDir,
                              @Param("keyword") String keyword,
                              @Param("productName") String productName) {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            return "redirect:/login-admin";
        }

        Page<ChiTietSanPham> page = chiTietSanPhamService.listByPageAndProductName(pageNum, sortField, sortDir, keyword, productName);
        List<ChiTietSanPham> listChiTietSanPham = page.getContent();

        long startCount = (pageNum - 1) * ChiTietSanPhamService.PRODUCT_DETAIL_PER_PAGE + 1;
        long endCount = startCount + ChiTietSanPhamService.PRODUCT_DETAIL_PER_PAGE - 1;
        if (endCount > page.getTotalElements()) {
            endCount = page.getTotalElements();
        }

        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("startCount", startCount);
        model.addAttribute("endCount", endCount);
        model.addAttribute("totalItem", page.getTotalElements());
        model.addAttribute("listChiTietSanPham", listChiTietSanPham);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", reverseSortDir);
        model.addAttribute("keyword", keyword);
        model.addAttribute("productName", productName);

        return "admin/chitietsanpham/product_detail";
    }
    @GetMapping("/admin/productDetails/new")
    public String newProduct(Model model){
        HttpSession session = request.getSession();
        if(session.getAttribute("admin") == null ){
            return "redirect:/login-admin" ;
        }
        List<SanPham> listSanPham = sanPhamService.listAll();
        List<ChatLieu> listChatLieu = chatLieuService.getAllChatLieu();
        List<KhuyenMai> listKhuyenMai = khuyenMaiService.listAll();
        List<MauSac> listMauSac = mauSacService.getAllMauSac();
        List<KichCo> listKichCo = kichCoService.getAllKichCo();
        List<CauTrucKhuy> listCauTrucKhuy = cauTrucKhuyService.getAllCauTrucKhuy();
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setTrangThai(1);
        model.addAttribute("chiTietSanPham",chiTietSanPham);
        model.addAttribute("listKhuyenMai",listKhuyenMai);
        model.addAttribute("listSanPham",listSanPham);
        model.addAttribute("listChatLieu",listChatLieu);
        model.addAttribute("listMauSac",listMauSac);
        model.addAttribute("listKichCo",listKichCo);
        model.addAttribute("listCauTrucKhuy",listCauTrucKhuy);
        return "admin/chitietsanpham/product_detail_create";
    }
    @PostMapping("/admin/productDetails/save")
    public String saveProductDetails(ChiTietSanPham chiTietSanPham, RedirectAttributes ra) throws IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("admin") == null ){
            return "redirect:/login-admin" ;
        }
        List<ChiTietSanPham> list =  chiTietSanPhamService.findByIdSp(chiTietSanPham.getSanPham().getIdSanPham());
        Integer count = 0;
        for (ChiTietSanPham ctsp: list
        ) {
            if(ctsp.getMauSac()== chiTietSanPham.getMauSac()){
                if (ctsp.getIdChiTietSanPham() == chiTietSanPham.getIdChiTietSanPham()) {
                    count = 0;
                } else {
                    count++;
                }
            }

        }

        if(count > 0){
            ra.addFlashAttribute("thongbaoTrung", "Sản phẩm đã tồn tại");
            return "redirect:/admin/productDetails/edit/"+chiTietSanPham.getIdChiTietSanPham();
        }
        chiTietSanPhamService.save(chiTietSanPham);
        ra.addFlashAttribute("message","Thay Đổi Thành Công.");
        return "redirect:/admin/productDetails";
    }
    @GetMapping("/admin/productDetails/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model,
                              RedirectAttributes ra){
        try{
            HttpSession session = request.getSession();
            if(session.getAttribute("admin") == null ){
                return "redirect:/login-admin" ;
            }
            ChiTietSanPham chiTietSanPham = chiTietSanPhamService.get(id);
            List<SanPham> listSanPham = sanPhamService.listAll();
            List<MauSac> listMauSac = mauSacService.getAllMauSac();

            model.addAttribute("chiTietSanPham",chiTietSanPham);
            model.addAttribute("listSanPham",listSanPham);
            model.addAttribute("listMauSac",listMauSac);

            return "admin/chitietsanpham/product_detail_edit";
        }catch (ChiTietSanPhamNotFountException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/admin/productDetails";
        }
    }
    @PostMapping("/admin/productDetails/update")
    public String updateProductDetails(ChiTietSanPham chiTietSanPham, RedirectAttributes ra) throws IOException, ChiTietSanPhamNotFountException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            return "redirect:/login-admin";
        }
        List<ChiTietSanPham> list =  chiTietSanPhamService.findByIdSp(chiTietSanPham.getSanPham().getIdSanPham());
        Integer count = 0;
        for (ChiTietSanPham ctsp: list
        ) {
            if(ctsp.getMauSac()== chiTietSanPham.getMauSac() ){
                if (ctsp.getIdChiTietSanPham() == chiTietSanPham.getIdChiTietSanPham()) {
                    count = 0;
                } else {
                    count++;
                }
            }

        }

        if(count > 0){
            ra.addFlashAttribute("thongbaoTrung", "Sản phẩm đã tồn tại");
            return "redirect:/admin/productDetails/edit/"+chiTietSanPham.getIdChiTietSanPham();
        }
        chiTietSanPhamService.save(chiTietSanPham);
        ra.addFlashAttribute("message","Thay Đổi Thành Công.");
        return "redirect:/admin/productDetails";
    }

}
