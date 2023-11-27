package com.example.datn.RestController.SanPham;

import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamRestController {
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @PutMapping("/update")
    ResponseEntity<?> update(ChiTietSanPham chiTietSanPham){
        return ResponseEntity.status(HttpStatus.OK).body(chiTietSanPhamService.update(chiTietSanPham));
    }
    @GetMapping("/countSoLuong/{idChiTietSanPham}")
    ResponseEntity<?> countSeri(@PathVariable("idChiTietSanPham") Integer idChiTietSanPham){
        return ResponseEntity.status(HttpStatus.OK).body(chiTietSanPhamService.countSoLuong(idChiTietSanPham));
    }
}
