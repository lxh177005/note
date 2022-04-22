package com.xingxin.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * @author liuxh
 * @date 2022/3/9
 */
public class ObjectUtils {
    /**
     * 判断对象中属性值是否全为空
     *
     * @param object 实体类
     * @return 是否为空
     */
    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (StringUtils.equals(f.getName(),"serialVersionUID")){
                    continue;
                }
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("参数异常");
        }
        return true;

    }
}
