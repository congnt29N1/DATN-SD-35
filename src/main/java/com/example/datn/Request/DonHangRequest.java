package com.example.datn.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DonHangRequest {
    private Integer idDonHang;
    private String lyDo;
    private Integer trangThaiDonHang;
}
