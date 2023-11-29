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
@Table(name = "loplot")
public class LopLot {
    @Id
    @Column(name = "id_lop_lot")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLopLot;

    @Column(name = "ten_lop_lot")
    private String tenLopLot;

    @Column(name = "mo_ta_lop_lot")
    private String moTaLopLot;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;
}
