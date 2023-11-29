package com.example.datn.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Table(name = "chucvu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chuc_vu")
    private Integer idChucVu;

    @Column(name = "ten_chuc_vu", length = 40, nullable = false,unique = true)
    private Integer tenChucVu;

    @Column(name = "TrangThai", length = 150, nullable = false)
    private String mota;

    public ChucVu() {
    }

    public ChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }



    public Integer getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }



    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChucVu chucVu = (ChucVu) o;
        return Objects.equals(idChucVu, chucVu.idChucVu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChucVu);
    }


}
