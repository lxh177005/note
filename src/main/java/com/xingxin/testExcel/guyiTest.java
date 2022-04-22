package com.xingxin.testExcel;

import com.alibaba.fastjson.JSON;
import com.xingxin.entity.Cinema;
import com.xingxin.entity.GuyiData;
import com.xingxin.entity.PersonData;
import com.xingxin.utils.EasyPoiUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxh
 * @date 2021/8/10
 */
@Slf4j
public class guyiTest {
    public static void main(String[] args) throws IOException {
        List<GuyiData> list = EasyPoiUtil.importExcel(
                "E:\\myFiles\\工作簿1.xls", 0, 1, GuyiData.class);
            log.info(JSON.toJSONString(list));
    }
}
