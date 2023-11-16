package com.example.datn.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TimKiemRequest {
    @JsonProperty("mauSacId")
    private List<Integer> mauSacId;
    @JsonProperty("danhMucId")
    private List<Integer> danhMucId;
    @JsonProperty("tenSanPham")
    private String tenSanPham;
    @JsonProperty("sizeId")
    private List<Integer> sizeId;
    @JsonProperty("xeTaId")
    private List<Integer> xeTaId;
    private List<Integer> kieuDetId;
    @JsonProperty("chatlieuId")
    private List<Integer> chatlieuId;

}
