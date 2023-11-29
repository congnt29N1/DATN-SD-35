package com.example.datn.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "kieudet")
public class KieuDet {
    @Id
    @Column(name = "id_kieu_det")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKieuDet;

    @Column(name = "ten_kieu_det")
    private String tenKieuDet;

    @Column(name = "mo_ta_kieu_det")
    private String moTaKieuDet;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;
}
