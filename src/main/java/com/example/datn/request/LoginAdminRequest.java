package com.example.datn.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginAdminRequest {
    private String email;
    private String password;
}
