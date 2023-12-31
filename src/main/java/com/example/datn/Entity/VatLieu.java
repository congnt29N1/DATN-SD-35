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
@Table(name = "vatlieu")
public class VatLieu {
    @Id
    @Column(name = "id_vat_lieu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVatLieu;

    @Column(name = "ten_vat_lieu")
    private String tenVatLieu;

    @Column(name = "mo_ta_vat_lieu")
    private String moTaVatLieu;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;
}
