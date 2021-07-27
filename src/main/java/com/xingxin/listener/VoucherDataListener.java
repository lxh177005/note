package com.xingxin.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.xingxin.entity.VoucherData;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuxh
 * @date 2021/7/24
 */
@Slf4j
public class VoucherDataListener extends AnalysisEventListener<VoucherData> {
    @Override
    public void invoke(VoucherData voucherData, AnalysisContext analysisContext) {
        log.info("读取到的数据：{}", JSON.toJSONString(voucherData));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }
}
