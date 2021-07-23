package com.xingxin.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liuxh
 * @date 2021/7/23
 */
@Data
public class CinemaData {

    /**
     * 设置excel 表头
     */
    @ExcelProperty(value = "id", index = 0)
    private Integer id;

    @ExcelProperty(value = "电影", index = 1)
    private String movie;

    @ExcelProperty(value = "描述", index = 2)
    private String description;

    @ExcelProperty(value = "评分", index = 3)
    private Float rating;
}
