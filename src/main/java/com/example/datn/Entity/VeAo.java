package com.example.datn.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "veao")
public class VeAo {
    @Id
    @Column(name = "id_ve_ao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVeAo;

    @Column(name = "ten_ve_ao")
    private String tenVeAo;

    @Column(name = "mo_ta_ve_ao")
    private String moTaVeAo;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;
}
