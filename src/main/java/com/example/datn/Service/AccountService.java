package com.example.datn.Service;

import com.example.datn.Entity.KhachHang;
import com.example.datn.Request.ChangePassRequest;
import com.example.datn.Request.RegisterRequest;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.HashMap;
import java.util.Optional;

public interface AccountService {
    ResponseEntity<?> register (RegisterRequest registerRequest) throws Exception;
    HashMap<Integer, String > getListTP();
    HashMap<Integer, String > getListQuan(Integer idTP) throws Exception;
    HashMap<String, String> getListPhuong(Integer idQH) throws Exception;
    ResponseEntity<?> changePass (Principal p, ChangePassRequest changePassRequest) throws Exception;
    void createPasswordResetTokenForUsser(KhachHang user, String token);

    String validatePasswordResetToken(final String token);
    Optional<KhachHang> getUserByPasswordResetToken(final String token);
    void changeforgotPass(KhachHang khachHang, String pass);

}
