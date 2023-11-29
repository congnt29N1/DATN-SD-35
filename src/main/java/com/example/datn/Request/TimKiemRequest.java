package com.example.datn.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TimKiemRequest {
        @JsonProperty("thuongHieuId")
    private List<Integer> thuongHieuId;
    @JsonProperty("danhMucId")
    private List<Integer> danhMucId;
    @JsonProperty("sizeId")
    private List<Integer> sizeId;
    @JsonProperty("mauSacId")
    private List<Integer> mauSacId;
    @JsonProperty("vatLieuId")
    private List<Integer> vatLieuId;
    @JsonProperty("dayDeoId")
    private List<Integer> dayDeoId;
    @JsonProperty("tenSanPham")
    private String tenSanPham;
//    @JsonProperty("mauSacId")
//    private List<Integer> mauSacId;
//    @JsonProperty("danhMucId")
//    private List<Integer> danhMucId;
//    @JsonProperty("tenSanPham")
//    private String tenSanPham;
//    @JsonProperty("sizeId")
//    private List<Integer> sizeId;
    @JsonProperty("xeTaId")
    private List<Integer> xeTaId;
    private List<Integer> kieuDetId;
    @JsonProperty("chatlieuId")
    private List<Integer> chatlieuId;
    @JsonProperty("veaoId")
    private List<Integer> veaoId;
    @JsonProperty("lopLotId")
    private List<Integer> lopLotId;
    @JsonProperty("cahtruckhuyId")
    private List<Integer> cahtruckhuyId;
}
