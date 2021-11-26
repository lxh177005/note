package com.xingxin.enums;

/**
 * @author liuxh
 * @date 2021/11/24
 */
public enum YesOrNoEnum {
    /**
     * 否
     */
    NO(0),

    /**
     * 是
     */
    YES(1);

    private Integer value;

    public Integer value() {
        return value;
    }

    YesOrNoEnum(Integer value) {
        this.value = value;
    }
}
