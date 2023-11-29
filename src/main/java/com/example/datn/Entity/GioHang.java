package com.example.datn.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "giohang")
public class GioHang {
    @Id
    @Column(name = "id_gio_hang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGioHang;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    @Column(name = "ngay_tao_gio_hang")
    private Date ngayTaoGioHang;

    @Column(name = "trang_thai_gio_hang")
    private Integer trangThaiGioHang;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "thoi_gian_cap_nhap_gio_hang")
    private Timestamp thoiGianCapNhapGioHang;

}
