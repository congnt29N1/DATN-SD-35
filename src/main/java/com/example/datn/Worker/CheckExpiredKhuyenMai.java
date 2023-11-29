package com.example.datn.Worker;

import com.example.datn.Entity.KhuyenMai;
import com.example.datn.Service.KhuyenMaiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CheckExpiredKhuyenMai {

    @Autowired
    KhuyenMaiService khuyenMaiService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void deactiveExpiredKhuyenMai (){
        List<KhuyenMai> listKhuyenMai = khuyenMaiService.getExpiredKhuyenMai();
        log.info("Số khuyến mại hết hạn : {}", listKhuyenMai.size());
        listKhuyenMai.forEach(item->{
            item.setEnabled(false);
            khuyenMaiService.save(item);
        });
    }
}
