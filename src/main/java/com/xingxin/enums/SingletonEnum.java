package com.xingxin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 *
 * 枚举单例，不仅能避免多线程的同步问题，还能防止java反射和反序列化创建新的对象
 * @author liuxh
 * @date 2021/9/5
 */
@Getter
@AllArgsConstructor
public enum SingletonEnum {
    /**
     * 枚举单例
     */
    INSTANCE, ENUM_TEST;

    public void hello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        /*
         * javap -p E:\learn\note\target\classes\com\xingxin\enums\SignletonEnum.class
         * 反编译 枚举类
            Compiled from "SignletonEnum.java"
            public final class com.xingxin.enums.SignletonEnum extends java.lang.Enum<com.xingxin.enums.SignletonEnum> {
            public static final com.xingxin.enums.SignletonEnum INSTANCE;
            private static final com.xingxin.enums.SignletonEnum[] $VALUES;
            public static com.xingxin.enums.SignletonEnum[] values();
            public static com.xingxin.enums.SignletonEnum valueOf(java.lang.String);
            private com.xingxin.enums.SignletonEnum();
            public void hello();
            public static void main(java.lang.String[]);
            static {};
           }
         */
        SingletonEnum instance = SingletonEnum.INSTANCE;
        System.out.println("instance = " + instance);
        SingletonEnum.INSTANCE.hello();
        SingletonEnum[] values = SingletonEnum.values();
        System.out.println("values = " + Arrays.toString(values));
        SingletonEnum instance1 = SingletonEnum.valueOf("INSTANCE");
        System.out.println("instance1 = " + instance1);
        System.out.println(instance == instance1);


    }
}
