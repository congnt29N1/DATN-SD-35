package com.example.datn.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "kichco")
public class KichCo {
    @Id
    @Column(name = "id_kich_co")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKichCo;

    @Column(name = "ten_kich_co")
    private String tenKichCo;

    @Column(name = "mo_ta_kich_co")
    private String moTaKichCo;

    @Column(name = "ngay_tao_kich_co")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTaoKichCo;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;

}
