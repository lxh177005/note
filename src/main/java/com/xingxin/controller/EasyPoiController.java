package com.xingxin.controller;

import com.alibaba.fastjson.JSON;
import com.xingxin.entity.Cinema;
import com.xingxin.entity.PersonData;
import com.xingxin.utils.EasyPoiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxh
 * @date 2021/7/24
 */
@RestController
@RequestMapping("/excel")
@Slf4j
public class EasyPoiController {

    @GetMapping("/export")
    public String exportExcel(HttpServletResponse response) {
        List<PersonData> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PersonData person = new PersonData();
            person.setName("张三" + i);
            person.setUsername("张三" + i);
            person.setPhoneNumber("18888888888");
            personList.add(person);
        }
        try {
            EasyPoiUtil.exportExcel(personList, "员工信息",
                    "员工信息sheet", PersonData.class, "员工信息表", response);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/import")
    public List<Cinema> importExcel() {
        String path = "E:\\myFiles\\1627047338858.xlsx";
        List<Cinema> list = new ArrayList<>();
        try {
             list = EasyPoiUtil.importExcel(path, 0, 1, Cinema.class);
            log.info(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 导入数据
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public List<PersonData> importExcel(MultipartFile file) throws IOException {
        List<PersonData> list = EasyPoiUtil.importExcel(file, PersonData.class);
        log.info(JSON.toJSONString(list));
        return list;
    }
}