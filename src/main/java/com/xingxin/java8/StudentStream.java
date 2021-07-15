package com.xingxin.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StudentStream {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
         new Student("tom",12,175),
         new Student("jerry",12,176),
         new Student("kitty",18,175),
         new Student("david",19,175),
         new Student("lucy",10,175)
        );
        List<Student> newList = studentList.stream()
//                .filter(student -> student.getAge() > 12)
//                .sorted( (s1,s2) -> s2.getAge()-s1.getAge())
                .filter(student -> student.getName().indexOf("y")>=0)
                .collect(Collectors.toList());
        System.out.println("newList = " + newList);

        //只简单的调用的话 可以直接点方法 不用.stream()
        //.thenComparing 继续按着某个规则排序
        //.reversed()  反转 倒序排列
        //身高倒序排列，之后年龄正序排列
        studentList.sort(Comparator.comparing(Student::getHeight).reversed()
                .thenComparing(Student::getAge));
        studentList.forEach(System.out::println);

        //map
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        map.forEach((k, v) -> System.out.println(k + "," + v));
    }
}
