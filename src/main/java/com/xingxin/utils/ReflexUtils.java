package com.xingxin.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射技术
 *
 * @author liuxh
 * @date 2021/9/5
 */
public class ReflexUtils {

    public static UserEntity reflexUserEntity() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 使用java反射技术初始化对象，默认执行无参构造函数。
        Class<?> classInfo = Class.forName("com.xingxin.utils.UserEntity");
//        UserEntity userEntity = (UserEntity) classInfo.newInstance();

        // 利用反射技术改变 私有无参构造方法 权限
        Constructor<?> declaredConstructor = classInfo.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        UserEntity userEntity = (UserEntity) declaredConstructor.newInstance();
        return userEntity;
    }

    public static UserEntity reflexUserEntity(Integer id, String email) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 使用java反射技术初始化对象，默认执行无参构造函数。
        Class<?> classInfo = Class.forName("com.xingxin.utils.UserEntity");
//        UserEntity userEntity = (UserEntity) classInfo.newInstance();

        // 利用反射技术改变 私有无参构造方法 权限
        Constructor<?> declaredConstructor = classInfo.getDeclaredConstructor(Integer.class, String.class);
        declaredConstructor.setAccessible(true);

        UserEntity userEntity = (UserEntity) declaredConstructor.newInstance(id, email);
        return userEntity;
    }


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        UserEntity userEntity = ReflexUtils.reflexUserEntity();
        userEntity.setId(1);
        userEntity.setEmail("lxh177005@163.com");
        System.out.println("userEntity = " + userEntity);

        UserEntity userEntity1 = ReflexUtils.reflexUserEntity(2, "abc@163.com");
        System.out.println("userEntity1 = " + userEntity1);

        // java反射技术拿到对象属性
        Class<?> classInfo = Class.forName("com.xingxin.utils.UserEntity");
        Field[] fields = classInfo.getFields();
        Method[] methods = classInfo.getMethods();
        System.out.println("fields = " + Arrays.toString(fields));
        System.out.println("methods = " + Arrays.toString(methods));
    }

}

@Getter
@Setter
@ToString
class UserEntity {
    private Integer id;
    private String email;

    private UserEntity() {
        System.out.println("无参构造器执行了。。");
    }

    private UserEntity(Integer id, String email) {
        this.id = id;
        this.email = email;
    }
}
