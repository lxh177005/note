package com.xingxin.annotation;

import java.lang.annotation.*;

/**
 *
 *
 * @author liuxh
 * @date 2021/9/12
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface XingxinCurrentLimit {

    // 限流名称
    String name() default "";

    // 次数，默认每秒可以访问20次
    double token() default 20;
}
