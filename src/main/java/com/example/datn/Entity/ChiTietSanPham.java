package com.example.datn.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "chitietsanpham")
public class ChiTietSanPham {
    @Id
    @Column(name = "id_chi_tiet_san_pham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChiTietSanPham;

    @JoinColumn(name = "ma_chi_tiet_san_pham")
    private String maChiTietSanPham;

    @ManyToOne
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "id_day_deo")
    private DayDeo dayDeo;

    @ManyToOne
    @JoinColumn(name = "id_khuyen_mai")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_vat_lieu")
    private VatLieu vatLieu;

    @ManyToOne
    @JoinColumn(name = "id_kich_co")
    private KichCo kichCo;

    @Column(name = "chieu_dai_day_deo")
    private Double chieuDaiDayDeo;

    @Column(name = "duong_kinh_mat_dong_ho")
    private Double duongKinhMatDongHo;

    @Column(name = "do_day_mat_dong_ho")
    private Double doDayMatDongHo;

    @Column(name = "do_chiu_nuoc")
    private Integer doChiuNuoc;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "gia_san_pham")
    private Double giaSanPham;
    @Column(name = "so_luong")
    private Integer soLuong;
    @ManyToOne
    @JoinColumn(name = "id_chat_lieu")
    private ChatLieu chatLieu;
    @ManyToOne
    @JoinColumn(name = "id_cau_truc_khuy")
    private CauTrucKhuy cauTrucKhuy;
    @ManyToOne
    @JoinColumn(name = "id_hoa_tiet")
    private HoaTiet hoaTiet;
    @ManyToOne
    @JoinColumn(name = "id_kieu_tui")
    private KieuTui kieuTui;
    @ManyToOne
    @JoinColumn(name = "id_kieu_det")
    private KieuDet kieuDet;
    @ManyToOne
    @JoinColumn(name = "id_lop_lot")
    private LopLot lopLot;
    @ManyToOne
    @JoinColumn(name = "id_ve_ao")
    private VeAo veAo;
    @ManyToOne
    @JoinColumn(name = "id_xe_ta")
    private XeTa xeTa;
    @Column(name = "so_mi_phu_hop")
    private String soMiPhuHop;
    @Column(name = "giay_phu_hop")
    private String giayPhuHop;
    @OneToMany(mappedBy = "chiTietSanPham", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<PhanHoi> listPhanHoi ;

}
