package com.example.datn.Service.Impl;

import com.example.datn.Entity.ChiTietSanPham;
import com.example.datn.Exception.ChiTietSanPhamNotFountException;
import com.example.datn.Repository.ChiTietSanPhamRepository;
import com.example.datn.Response.SanPhamAdminResponse;
import com.example.datn.Response.TimKiemSettingResponse;
import com.example.datn.Service.ChatLieuService;
import com.example.datn.Service.ChiTietSanPhamService;
import com.example.datn.Service.DanhmucService;
import com.example.datn.Service.KhuyenMaiService;
import com.example.datn.Service.KichCoService;
import com.example.datn.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    DanhmucService danhmucService;
    @Autowired
    KhuyenMaiService khuyenMaiService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    KichCoService kichCoService;
    @Autowired
    ChatLieuService chatLieuService;
    @Override
    public int totalPageSearchSP(String key, int pageNum) {
        return chiTietSanPhamRepository.searchByKey(key, PageRequest.of(pageNum - 1, 5)).getTotalPages();
    }

    @Override
    public List<SanPhamAdminResponse> searchSP(String key, int pageNum) {
        List<ChiTietSanPham> lstChiTietSanPhams = chiTietSanPhamRepository.searchByKey(key,PageRequest.of(pageNum - 1, 5)).getContent();

        List<SanPhamAdminResponse> lst = lstChiTietSanPhams
                .stream()
                .map(lstSP -> SanPhamAdminResponse
                        .builder()
                        .idChiTietSanPham(lstSP.getIdChiTietSanPham())
                        .maChiTietSanPham(lstSP.getMaChiTietSanPham())
                        .giaSanPham(lstSP.getGiaSanPham())
                        .sanPham(lstSP.getSanPham())
                        .mauSac(lstSP.getMauSac())
                        .khuyenMai(lstSP.getKhuyenMai())
                        .soLuong(lstSP.getIdChiTietSanPham())  // find All Imei status is enabled
                        .build()).collect(Collectors.toList());
        return lst;
    }

    @Override
    public TimKiemSettingResponse getTimKiemSetting() {
        TimKiemSettingResponse result = new TimKiemSettingResponse();
        result.setListDanhMuc(danhmucService.listAll());
        result.setListKichCo(kichCoService.getAllKichCo());
        result.setListMauSac(mauSacService.getAllMauSac());
        result.setListchatLieu(chatLieuService.getAllChatLieu());
        return result;
    }

    @Override
    public Integer countSoLuong(Integer idChiTietSanPham) {
        return chiTietSanPhamRepository.countSoLuong(idChiTietSanPham);
    }

    @Override
    public ChiTietSanPham getChiTietSanPhamById(Integer id) {
        return chiTietSanPhamRepository.findById(id).get();
    }

    @Override
    public ChiTietSanPham update(ChiTietSanPham chiTietSanPham) {
        return chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public Page<ChiTietSanPham> findByMaSP(String maSanPham, int pageNum) {
        return null;
    }

    @Override
    public Page<ChiTietSanPham> getALlChiTietSanPhamPage(int pageNum) {
        return chiTietSanPhamRepository.findAllHung(PageRequest.of(pageNum - 1, 5));
    }

    @Override
    public List<SanPhamAdminResponse> getAllSanPhamAminResponse(int pageNum) {
        List<ChiTietSanPham> lstChiTietSanPhams = getALlChiTietSanPhamPage(pageNum).getContent();

        List<SanPhamAdminResponse> lst = lstChiTietSanPhams
                .stream()
                .map(lstSP -> SanPhamAdminResponse
                        .builder()
                        .idChiTietSanPham(lstSP.getIdChiTietSanPham())
                        .maChiTietSanPham(lstSP.getMaChiTietSanPham())
                        .giaSanPham(lstSP.getGiaSanPham())
                        .sanPham(lstSP.getSanPham())
                        .mauSac(lstSP.getMauSac())
                        .khuyenMai(lstSP.getKhuyenMai())
                        .soLuong(lstSP.getIdChiTietSanPham())// find All Imei status is enabled
                        .build()).collect(Collectors.toList());
        return lst;
    }

    @Override
    public ChiTietSanPham findByMaChiTietSanPham(String maChimaTietSanPham) {
        return chiTietSanPhamRepository.findByMaChiTietSanPham(maChimaTietSanPham);
    }

    @Override
    public ChiTietSanPham getChiTietSanPhamByMa(String ma) {
        return chiTietSanPhamRepository.findByMaChiTietSanPham(ma);
    }

    @Override
    public List<ChiTietSanPham> listAll() {
        return chiTietSanPhamRepository.findAll(Sort.by("maChiTietSanPham").ascending());
    }

    @Override
    public boolean isUniqueChiTietSanPham(String maChiTietSanPham, String tenSanPham, String tenXeTa, String tenMauSac, String tenChatLieu, String tenKichCo, String tenCauTrucKhuy, String tenHoaTiet, String tenKieuTui, String tenKieuDet, String tenLopLot, String tenVeAo) {
        ChiTietSanPham existingByMa = chiTietSanPhamRepository.findByMaChiTietSanPham(maChiTietSanPham);
        ChiTietSanPham existingByNames = chiTietSanPhamRepository.findBySanPham_TenSanPhamAndMauSac_TenMauSacAndChatLieu_TenChatLieuAndKichCo_TenKichCoAndCauTrucKhuy_TenCauTrucKhuyAndHoaTiet_TenHoaTietAndKieuTui_TenKieuTuiAndKieuDet_TenKieuDetAndLopLot_TenLopLotAndVeAo_TenVeAoAndXeTa_TenXeTa(
                tenSanPham,tenMauSac,tenChatLieu,tenKichCo,tenCauTrucKhuy,tenHoaTiet,tenKieuTui,tenKieuDet,tenLopLot,tenVeAo,tenXeTa
        );

        return (existingByMa == null && existingByNames == null);
    }

    @Override
    public boolean isUniqueChiTietSanPhamUpdate(Integer idChiTietSanPham, String maChiTietSanPham, String tenSanPham, String tenMauSac, String tenChatLieu, String tenKichCo, String tenCauTrucKhuy, String tenHoaTiet, String tenKieuTui, String tenKieuDet, String tenLopLot, String tenVeAo, String tenXeTa) {
        ChiTietSanPham existingById = chiTietSanPhamRepository.findByIdChiTietSanPham(idChiTietSanPham);
        ChiTietSanPham existingByMa = chiTietSanPhamRepository.findByMaChiTietSanPham(maChiTietSanPham);
        ChiTietSanPham existingByNames = chiTietSanPhamRepository.findBySanPham_TenSanPhamAndMauSac_TenMauSacAndChatLieu_TenChatLieuAndKichCo_TenKichCoAndCauTrucKhuy_TenCauTrucKhuyAndHoaTiet_TenHoaTietAndKieuTui_TenKieuTuiAndKieuDet_TenKieuDetAndLopLot_TenLopLotAndVeAo_TenVeAoAndXeTa_TenXeTa(
                tenSanPham,tenMauSac,tenChatLieu,tenKichCo,tenCauTrucKhuy,tenHoaTiet,tenKieuTui,tenKieuDet,tenLopLot,tenVeAo,tenXeTa
        );

        return (existingByMa == null && existingByNames == null && existingById == null);
    }

    @Override
    public ChiTietSanPham save(ChiTietSanPham chiTietSanPham) {
        return chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham get(Integer id) throws ChiTietSanPhamNotFountException {
        try{
            return chiTietSanPhamRepository.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new ChiTietSanPhamNotFountException("không tìm thấy sản phẩm có id" + id);
        }
    }

    @Override
    public Page<ChiTietSanPham> listByPageAndProductName(int pageNum, String sortField, String sortDir, String keyword, String productName) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum - 1, PRODUCT_DETAIL_PER_PAGE, sort);

        if (StringUtils.isEmpty(productName) && StringUtils.isEmpty(keyword)) {
            return chiTietSanPhamRepository.findAll(pageable);
        } else if (StringUtils.isEmpty(productName)) {
            return chiTietSanPhamRepository.findByKeyword(keyword, pageable);
        } else if (StringUtils.isEmpty(keyword)) {
            return chiTietSanPhamRepository.findBySanPham_TenSanPhamContainingIgnoreCase(productName, pageable);
        } else {
            return chiTietSanPhamRepository.findByProductNameAndKeyword(keyword, productName, pageable);
        }
    }

    @Override
    public List<ChiTietSanPham> findByIdSp(Integer IdSP) {
        return chiTietSanPhamRepository.findByIdSp(IdSP);
    }
}
