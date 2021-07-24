package com.xingxin.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.xingxin.entity.Cinema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxh
 * @date 2021/7/23
 */
@Slf4j
public class CinemaListener extends AnalysisEventListener<Cinema> {

    @Override
    public void invoke(Cinema cinema, AnalysisContext analysisContext) {
        log.info("读取到的数据：{}", JSON.toJSONString(cinema));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }

}
