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
public class QuanHuyenResponse {
    @JsonProperty("ProvinceID")
    private Integer provinceID;
    @JsonProperty("DistrictID")
    private Integer districtID;
    @JsonProperty("DistrictName")
    private String districtName;
}
