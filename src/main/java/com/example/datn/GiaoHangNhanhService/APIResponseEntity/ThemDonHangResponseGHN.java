package com.example.datn.GiaoHangNhanhService.APIResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemDonHangResponseGHN {

    @JsonProperty("order_code")
    private String orderCode;
    @JsonProperty("expected_delivery_time")
    private String expectedDeliveryTime;
}
