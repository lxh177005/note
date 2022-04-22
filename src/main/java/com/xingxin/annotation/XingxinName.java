package com.xingxin.annotation;


import java.lang.annotation.*;

/**
 *
 *
 * @author liuxh
 * @date 2021/9/12
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface XingxinName {
}
