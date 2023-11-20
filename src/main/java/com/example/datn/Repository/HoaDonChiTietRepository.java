package com.example.datn.Repository;

import com.example.datn.Entity.DonHang;
import com.example.datn.Entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
    @Query(value = """
            select  h from HoaDonChiTiet h join DonHang dh on h.donHang.idDonHang = dh.idDonHang
            where h.donHang.idDonHang =?1
            order by h.idHoaDonChiTiet asc 
            """
    )
    public List<HoaDonChiTiet> findHDCTBYIdDonHang(int id);

    List<HoaDonChiTiet> findByDonHan(DonHang donHang);

    @Query(value = """
            select h from HoaDonChiTiet  h join DonHang d on h.donHang.idDonHang = d.idDonHang
            where d.maDonHang =?1
                        """)
    public List<HoaDonChiTiet> findByMaDonHang(String  maDonHang);
    @Query(value = """
        UPDATE HoaDonChiTiet h
        SET h.soLuong = h.soLuong + ?1
        WHERE h.idHoaDonChiTiet = ?2
    """)
    @Modifying
    public void updateSoLuongSanPham(int soLuong, int idHoaDonChiTiet);


    @Query(value = """
        DELETE 
        FROM HoaDonChiTiet h
        WHERE h.idHoaDonChiTiet = ?1
    """)
    @Modifying
    public void xoaHDCT(int idHoaDonChiTiet);
    public HoaDonChiTiet findByIdHoaDonChiTiet(int id);

    @Query(value = """
        UPDATE HoaDonChiTiet h
        SET h.soLuong = ?1
        WHERE h.idHoaDonChiTiet = ?2
    """)
    @Modifying
    public void updateSoLuongSanPhamWithEdit(int soLuong, int idHoaDonChiTiet);
    @Query("SELECT NEW HoaDonChiTiet(d.chiTietSanPham.sanPham.danhMuc.ten, d.soLuong," +
    "d.giaBan, d.donHang.phiVanChuyen)" + "from HoaDonChiTiet  d where d.donHang.ngayTao between ?1 and ?2 and d.donHang.trangThaiDonHang  = ?3")
    public List<HoaDonChiTiet> findWithCategoryAndTimeBetween(Date startTime, Date endTime, Integer status);

    @Query("SELECT NEW HoaDonChiTiet(d.soLuong, d.chiTietSanPham.sanPham.tenSanPham," +
            "d.giaBan, d.donHang.phiVanChuyen)" + "from HoaDonChiTiet  d where d.donHang.ngayTao between ?1 and ?2 and d.donHang.trangThaiDonHang  = ?3")
    public List<HoaDonChiTiet> findWithProductAndTimeBetween(Date startTime, Date endTime, Integer status);

    @Query("SELECT NEW HoaDonChiTiet( d.chiTietSanPham.idChiTietSanPham,d.soLuong,d.giaBan," +
            "d.donHang.phiVanChuyen)" + "from HoaDonChiTiet  d where d.donHang.ngayTao between ?1 and ?2 and d.donHang.trangThaiDonHang  = ?3")
    public List<HoaDonChiTiet> findWithOderDetailAndTimeBetween(Date startTime, Date endTime, Integer status);
    @Modifying
    @Transactional
    public void deleteByDonHang(DonHang donHang);
    @Query("select count(hd) from HoaDonChiTiet hd where hd.donHang.idDonHang =?1")
    Integer countHD (Integer id);

}
