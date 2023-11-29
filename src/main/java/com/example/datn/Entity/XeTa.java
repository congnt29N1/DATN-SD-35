package com.example.datn.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "xeta")
public class XeTa {
    @Id
    @Column(name = "id_xe_ta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idXeTa;

    @Column(name = "ten_xe_ta")
    private String tenXeTa;

    @Column(name = "mo_ta_xe_ta")
    private String moTaXeTa;

    @Column(name = "enabled",nullable = false)
    private boolean enabled;
    //xeta
}
