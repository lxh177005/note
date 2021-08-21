package com.xingxin.test;

import com.xingxin.entity.Cinema;
import com.xingxin.utils.ResponseResult;

/**
 * @author liuxh
 * @date 2021/8/17
 */
public enum SignPrizeEnum {
    SCORE(1, "积分"),
    COUPON(2, "优惠券"),
    VIRTUAL_COUPON(3, "西软卡券"),
    VIP_AMOUNT(4, "会员余额"),
    CASH(5, "现金红包");

    private Integer status;

    private String desc;

    SignPrizeEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static String getDesc(Integer status) {
        SignPrizeEnum[] enums = values();
        for (SignPrizeEnum typeEnum : enums) {
            if (typeEnum.status.equals(status)) {
                return typeEnum.desc;
            }
        }
        return null;
    }

    public static Integer getStatus(String desc) {
        SignPrizeEnum[] enums = values();
        for (SignPrizeEnum typeEnum : enums) {
            if (typeEnum.desc.equals(desc)) {
                return typeEnum.status;
            }
        }
        return null;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}
