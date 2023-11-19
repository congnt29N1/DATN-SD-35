package com.example.datn.controller;

import com.example.datn.Security.AccountFilterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TokenController {
    private final AccountFilterService accountFilterService;

    public TokenController(AccountFilterService accountFilterService) {
        this.accountFilterService = accountFilterService;
    }
    @PostMapping("/refresh-token")
    public ResponseEntity<String> refreshToken(HttpServletRequest request, Authentication authentication){
        String token = extractTokenFromRequest(request);
        if (token != null && authentication != null){
            boolean isUserValid = accountFilterService.isTokenValid(token, (UserDetails) authentication.getPrincipal());
            if (isUserValid){
                String newToken = accountFilterService.refreshToken(token);
                if (newToken != null){
                    return ResponseEntity.ok(newToken);
                }
            }
        }
        return ResponseEntity.badRequest().body("Lỗi không tạo được token");
    }
    private String extractTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
