package com.example.datn.RestController.SanPham;

import com.example.datn.Request.TimKiemRequest;
import com.example.datn.Response.SanPhamDetailResponse;
import com.example.datn.Response.TimKiemResponse;
import com.example.datn.Response.TimKiemSettingResponse;
import com.example.datn.Service.ChiTietSanPhamService;
import com.example.datn.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/san-pham")
public class SanPhamRestController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @PostMapping("/tim-kiem")
    public ResponseEntity<?> TimKiemSanPham (@RequestBody TimKiemRequest timKiemRequest){
        Set<TimKiemResponse> result = sanPhamService.getSanPhamByCondition(timKiemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/get-setting")
    public ResponseEntity<?> GetSettingTimKiem (){
        TimKiemSettingResponse result = chiTietSanPhamService.getTimKiemSetting();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/san-pham-detail/id-san-pham={idSP}")
    public ResponseEntity<?> GetSanPhamById(@PathVariable("idSP") Integer idSP){
        SanPhamDetailResponse result = sanPhamService.getDetailSanPhamById(idSP);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
