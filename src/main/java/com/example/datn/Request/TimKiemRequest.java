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
    @JsonProperty("mauSacId")
    private List<Integer> mauSacId;
    @JsonProperty("sizeId")
    private List<Integer> sizeId;
    @JsonProperty("xeTaId")
    private List<Integer> xeTaId;
    private List<Integer> kieuDetId;
    @JsonProperty("chatlieuId")
    private List<Integer> chatlieuId;
    @JsonProperty("cahtruckhuyId")
    private List<Integer> cahtruckhuyId;
}
