package com.example.datn.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {

    private Integer idKhachHang;

    private String tenKhachHang;

    private String soDienThoai;

    private String email;

    private Date ngaySinh;

    private Integer gioiTinh;

    private String matKhau;
}
