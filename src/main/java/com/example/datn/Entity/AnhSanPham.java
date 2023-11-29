package com.example.datn.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "anhsanpham")
public class AnhSanPham {
    @Id
    @Column(name = "id_anh_san_pham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnhSanPham;

    @Column(name = "link")
    private String link;

    @Column(name = "ten_anh")
    private String tenAnh;

    @JsonIgnore
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;

    public AnhSanPham(String tenAnh, SanPham sanPham) {
        this.tenAnh = tenAnh;
        this.sanPham = sanPham;
    }
}
