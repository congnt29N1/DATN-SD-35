package com.example.datn.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePassForgetRequest {
    private String newPass;
    private String confirmPass;

}
