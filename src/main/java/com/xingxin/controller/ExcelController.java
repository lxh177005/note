package com.xingxin.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xingxin.dao.CinemaMapper;
import com.xingxin.entity.Cinema;
import com.xingxin.entity.CinemaData;
import com.xingxin.listener.CinemaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuxh
 * @date 2021/7/23
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private CinemaMapper cinemaMapper;

    /**
     * 简单写
     *
     * @return String
     */
    @GetMapping("/write")
    public String write() {
        String fileName = "E:\\myFiles\\" + System.currentTimeMillis() + ".xlsx";
        // 获取数据
        List<Cinema> cinemas = cinemaMapper.selectList(new QueryWrapper<Cinema>());
        // 导出到execl表格
        EasyExcel.write(fileName, CinemaData.class).sheet("test").doWrite(cinemas);
        return "success";
    }

    /**
     * 简单读
     * 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照DemoDataListener
     *
     * @return String
     */
    @GetMapping("/read")
    public String read(@RequestParam("fileName") String fileName) {
        String filePath = "E:\\myFiles\\" + fileName + ".xlsx";
        EasyExcel.read(filePath, Cinema.class, new CinemaListener()).sheet("test").doRead();
        return "success";
    }
}
