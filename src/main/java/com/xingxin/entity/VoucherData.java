package com.xingxin.entity;

import lombok.Data;

import java.lang.ref.PhantomReference;
import java.math.BigDecimal;

/**
 * @author liuxh
 * @date 2021/7/24
 */
@Data
public class VoucherData {

    private Integer id;
    private Integer month;
    private Integer day;
    private String bankName;
    private String voucherNo;
    private String mark;
    private String otherSubject;
    private BigDecimal debitSide;
    private BigDecimal creditSide;
    private String type;
    private BigDecimal amount;
    private boolean check;

}
