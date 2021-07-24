package com.xingxin.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xingxin.dao.CinemaMapper;
import com.xingxin.entity.Cinema;
import com.xingxin.entity.CinemaData;
import com.xingxin.listener.CinemaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author liuxh
 * @date 2021/7/23
 */
@RestController
@RequestMapping("/excel")
public class EasyExcelController {

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
        // 导出到execl表格
        EasyExcel.write(fileName, CinemaData.class).sheet("test").doWrite(getData());
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
        // 读取指定的sheet
        EasyExcel.read(filePath, Cinema.class, new CinemaListener()).sheet("test").doRead();
        // 读取全部shett
//        EasyExcel.read(fileName, Cinema.class, new CinemaListener()).doReadAll();
        return "success";
    }

    /**
     * 文件下载
     */
    @GetMapping("/download")
    public String download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), CinemaData.class).sheet("test").doWrite(getData());
        return "download success";
    }

    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Cinema.class, new CinemaListener()).doReadAll();
        return "upload success!";
    }

    /**
     * 获取数据
     *
     * @return List<Cinema>
     */
    private List<Cinema> getData() {
        return cinemaMapper.selectList(new QueryWrapper<Cinema>());
    }
}
