package com.xingxin.controller;

import com.alibaba.excel.EasyExcel;
import com.xingxin.entity.Cinema;
import com.xingxin.entity.VoucherData;
import com.xingxin.listener.CinemaListener;
import com.xingxin.listener.VoucherDataListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/7/24
 */
@RestController
@Slf4j
@RequestMapping("/voucher")
public class VoucherController {

    @GetMapping("/read")
    public String read() {
        String filePath = "E:\\guyi\\银行对账单.xls";
        EasyExcel.read(filePath, VoucherData.class, new VoucherDataListener()).doReadAll();
        return "success";
    }
}
