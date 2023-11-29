package com.example.datn.Repository;


import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Entity.SanPham;
import com.example.datn.Entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    @Query(value = "SELECT  * FROM sanpham where sanpham.trang_thai = 1 ORDER BY sanpham.id_san_pham DESC LIMIT 8", nativeQuery = true)
    List<SanPham> getSPnew();


    @Query(value = "SELECT h.chiTietSanPham.sanPham  FROM HoaDonChiTiet h where h.donHang.trangThaiDonHang = 3 group by h.chiTietSanPham.sanPham   ORDER BY  SUM(h.soLuong) DESC")
    List<SanPham> getSPchay();

    @Query(value = "SELECT s.listChiTietSanPham  FROM SanPham s where s.idSanPham = ?1 and s.trangThai = 1 ")
    List<ChiTietSanPham> getCTSP(Integer idSanPham);

    /**
     * @param pageable
     * @return
     * product pagination
     */
//    @Query(value = """
//        SELECT sp
//        FROM SanPham sp
//    """)
//    Page<SanPham> getPageSanPham(Pageable pageable);

    @Query("SELECT sp FROM SanPham  sp WHERE UPPER(CONCAT(sp.idSanPham,' ',sp.maSanPham,' ', sp.tenSanPham, ' ',sp.thuongHieu,' ', sp.danhMuc, ' ',sp.moTaSanPham)) LIKE %?1%")
    public Page<SanPham> findAll(String keyword, Pageable pageable);

    //@Query("SELECT th FROM ThuongHieu th WHERE UPPER(CONCAT(th.idThuongHieu, ' ', th.tenThuongHieu, ' ', th.moTaThuongHieu)) LIKE %?1%")
    //    public Page<ThuongHieu> findAll(String keyword, Pageable pageable);


    public SanPham findByTenSanPham(String tenSanPham);

    public  SanPham findByMaSanPham(String ma);
    public List<SanPham> findByThuongHieu(ThuongHieu tenSanPham);


    public SanPham findByIdSanPham(Integer idSanPham);
//@Query("""
//        SELECT c
//        FROM ChiTietSanPham c
//        WHERE LOWER(CONCAT(c.maChiTietSanPham,c.sanPham.tenSanPham)) LIKE %?1%  AND c.sanPham.trangThai = 1
//    """)
//public Page<ChiTietSanPham> searchByKey(String key, Pageable pageable);
//
//    @Query(nativeQuery = true,value = """
//        SELECT *
//        FROM chitietsanpham c JOIN sanpham sp ON c.id_san_pham = sp.id_san_pham
//        WHERE sp.ma_san_pham = ?1
//    """)
//    public Page<ChiTietSanPham> findByMaSP(String maSanPham, Pageable pageable);
//    @Query("""
//        SELECT ctsp
//        FROM ChiTietSanPham ctsp
//        WHERE ctsp.sanPham.trangThai = 1
//    """)
//    public Page<ChiTietSanPham> findAllHung(Pageable pageable);
//
//    ChiTietSanPham findByMaChiTietSanPham(String ma);
//    ChiTietSanPham findByIdChiTietSanPham(Integer idChiTietSanPham);
//    public Page<ChiTietSanPham> findBySanPham_TenSanPhamContainingIgnoreCase(String tenSanPham, Pageable pageable);
//    @Query("""
//        SELECT ctsp
//        FROM ChiTietSanPham ctsp
//        WHERE (LOWER(CONCAT(ctsp.maChiTietSanPham, ctsp.sanPham.tenSanPham)) LIKE %?1%)
//        AND (ctsp.sanPham.tenSanPham LIKE %?2%)
//    """)
//    public Page<ChiTietSanPham> findByProductNameAndKeyword(String keyword, String productName, Pageable pageable);
//
//    @Query(value = "select ctsp from ChiTietSanPham ctsp where ctsp.sanPham.idSanPham = ?1")
//    List<ChiTietSanPham> findByIdSp(Integer IdSP);
//
//    @Query("""
//        SELECT ctsp
//        FROM ChiTietSanPham ctsp
//        WHERE UPPER(ctsp.maChiTietSanPham) LIKE %?1%
//            OR UPPER(ctsp.kichCo.tenKichCo) LIKE %?1%
//            OR UPPER(ctsp.khuyenMai.tenKhuyenMai) LIKE %?1%
//            OR UPPER(ctsp.mauSac.tenMauSac) LIKE %?1%
//            OR UPPER(ctsp.sanPham.tenSanPham) LIKE %?1%
//            OR UPPER(ctsp.xeTa.tenXeTa) LIKE %?1%
//            OR UPPER(ctsp.kieuDet.tenKieuDet) LIKE %?1%
//            OR UPPER(ctsp.kieuTui.tenKieuTui) LIKE %?1%
//            OR UPPER(ctsp.veAo.tenVeAo) LIKE %?1%
//            OR UPPER(ctsp.hoaTiet.tenHoaTiet) LIKE %?1%
//            OR UPPER(ctsp.cauTrucKhuy.tenCauTrucKhuy) LIKE %?1%
//            OR UPPER(ctsp.lopLot.tenLopLot) LIKE %?1%
//            OR UPPER(ctsp.chatLieu.tenChatLieu) LIKE %?1%
//    """)
//    public Page<ChiTietSanPham> findByKeyword(String keyword, Pageable pageable);
//    @Query("SELECT ctsp FROM ChiTietSanPham  ctsp WHERE UPPER(CONCAT(ctsp.idChiTietSanPham,' ', ctsp.maChiTietSanPham," +
//            " ' ',ctsp.kichCo,' ', ctsp.khuyenMai,' ', ctsp.xeTa, ctsp.kieuTui,' ', ctsp.kieuDet,' ', ctsp.veAo,' '," +
//            " ctsp.hoaTiet,' ', ctsp.chatLieu,' ', ctsp.cauTrucKhuy,' ', ctsp.lopLot,' ', ctsp.chatLieu,' ',' '," +
//            " ctsp.mauSac,' ',ctsp.sanPham)) LIKE %?1%")
//    public Page<ChiTietSanPham> findAll(String keyword,Pageable pageable);
//    ChiTietSanPham findBySanPham_TenSanPhamAndMauSac_TenMauSacAndChatLieu_TenChatLieuAndKichCo_TenKichCoAndCauTrucKhuy_TenCauTrucKhuyAndHoaTiet_TenHoaTietAndKieuTui_TenKieuTuiAndKieuDet_TenKieuDetAndLopLot_TenLopLotAndVeAo_TenVeAoAndXeTa_TenXeTa(
//            String tenSanPham,
//            String tenMauSac,
//            String tenChatLieu,
//            String tenKichCo,
//            String tenCauTrucKhuy,
//            String tenHoaTiet,
//            String tenKieuTui,
//            String tenKieuDet,
//            String tenLopLot,
//            String tenVeAo,
//            String tenXeTa
//    );
//    @Query(value = "select count(s) from ChiTietSanPham s where s.trangThai =1" )
//    Integer countSoLuong(Integer chiTietSanPham);

}
