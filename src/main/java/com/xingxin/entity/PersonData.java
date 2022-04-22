package com.xingxin.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuxh
 * @date 2021/7/24
 */
@Data
public class PersonData implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "1", width = 15)
    private String name;

    /**
     * 登录用户名
     */
    @Excel(name = "用户名", orderNum = "2", width = 15)
    private String username;

    @Excel(name = "手机号码", orderNum = "3", width = 15)
    private String phoneNumber;

}
