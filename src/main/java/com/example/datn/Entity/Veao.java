package com.example.datn.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "veao")
public class Veao {
    @Id
    @Column(name = "id_ve_ao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVeao;

    @Column(name = "ten_ve_ao")
    private String tenVeao;

    @Column(name = "mo_ta_ve_ao")
    private String moTaVeao;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;
}
