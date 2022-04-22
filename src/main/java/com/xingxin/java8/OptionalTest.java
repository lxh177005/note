package com.xingxin.java8;

import com.xingxin.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * 罪恶克星
 * @author liuxh
 * @date 2021/7/15
 */
public class OptionalTest {
    public static void main(String[] args) {
        // ofNullable 存在返回，不存在返回其他，不报NPE
        Person p = null;
        Person p1 = Optional.ofNullable(p).orElse(new Person(1, "2"));
        System.out.println("p1 = " + p1);

        Person person = new Person();
        String email = Optional.ofNullable(person).map(Person::getEmail).orElse("***");
        System.out.println("email = " + email);

        person.setEmail("lxh177005@163.com");
        String email1 = Optional.ofNullable(person).map(Person::getEmail).orElse("***");
        System.out.println("email1 = " + email1);

        // 可以对值进行修改
        String aaa = Optional.ofNullable(person).map(p5 -> StringUtils.toRootUpperCase(p5.getEmail())).orElse("aaa");
        System.out.println("aaa = " + aaa);
        // 过滤
        String bbb = Optional.ofNullable(person).map(Person::getEmail).filter(p6 -> p6.contains("lxhaaa")).orElse("bbb");
        System.out.println("bbb = " + bbb);

        // map and flatmap
        String student = Optional.ofNullable(new School(1, null))
                .map(School::getStudent)
                .map(Student::getName)
                .orElse("abc");
        System.out.println("student = " + student);
//        Student student1 = Optional.ofNullable(new School(1, null))
//                .flatMap(School::getStudent)
//                .map(Student::getName)
//                .orElse("zhangsan");
//        System.out.println("student = " + student);

    }
    @Data
    @AllArgsConstructor
    static class School{
        private Integer id;
        private Student student;
    }
    @Data
    @AllArgsConstructor
     static class Student{
        private Integer id;
        private String name;
    }
}
