package com.example.datn.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "seri")
public class Seri {
    @Id
    @Column(name = "id_seri")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeri;

    @Column(name = "id_imei")
    private String idImei;

    @ManyToOne
    @JoinColumn(name = "id_chi_tiet_san_pham")
    private ChiTietSanPham chiTietSanPham;

    @Column(name = "ngay_nhap")
    private Timestamp ngayNhap;

    @Column(name = "ngay_ban")
    private Timestamp ngayBan;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don_chi_tiet")
    private HoaDonChiTiet hoaDonChiTiet;
}
