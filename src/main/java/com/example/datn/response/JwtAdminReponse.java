package com.example.datn.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtAdminReponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String ten;
    private String email;

    private List<String> listChucVu;
//    public  JwtAdminReponse(String token,Integer id, String ten, String email, List<String> listChucVu){
//        this.token = token;
//        this.id = id;
//        this.ten = ten;
//        this.email = email;
//        this.listChucVu = listChucVu;
//    }
}
