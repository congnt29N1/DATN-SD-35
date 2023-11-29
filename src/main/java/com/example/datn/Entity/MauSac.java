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
@Table(name = "mausac")
public class MauSac {
    @Id
    @Column(name = "id_mau_sac")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMauSac;

    @Column(name = "ten_mau_sac")
    private String tenMauSac;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;
}
