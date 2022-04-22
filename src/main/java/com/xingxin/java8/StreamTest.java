package com.xingxin.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;


public class StreamTest {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                // new Student("tom", 12, 200),
                // new Student("jerry", 12, 100),
                // new Student("kitty", 12, 30),
                // new Student("david", 19, 15),
                new Student("lucy", null, 100)
        );
        List<Student> newList = studentList.stream()
//                .filter(student -> student.getAge() > 12)
//                .sorted( (s1,s2) -> s2.getAge()-s1.getAge())
                .filter(student -> student.getName().indexOf("y") >= 0)
                .collect(Collectors.toList());
        System.out.println("newList = " + newList);

        //只简单的调用的话 可以直接点方法 不用.stream()
        //.thenComparing 继续按着某个规则排序
        //.reversed()  反转 倒序排列
        //身高倒序排列，之后年龄正序排列
        try {
            studentList.sort(Comparator.comparing(Student::getHeight).reversed()
                    .thenComparing(Student::getAge));
            studentList.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 取分组后最大、最小、平均、合值
        // 注意：要分组的值和比较的值不能出现null值，否则会npe
        try {
            Map<Integer, DoubleSummaryStatistics> map1 = studentList.stream()
                    .collect(Collectors.groupingBy(Student::getAge, Collectors.summarizingDouble(Student::getHeight)));
            map1.forEach((k, v) -> {
                long count = v.getCount();
                double max = v.getMax();
                double min = v.getMin();
                double average = v.getAverage();
                System.out.println("k=" + k + ",count=" + count + ",max=" + max + ",min=" + min + ",avg=" + average);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        double min1 = studentList.stream().filter(s -> s.getAge() != null).collect(Collectors.summarizingDouble(Student::getAge)).getMin();
        System.out.println("min1 = " + min1);
        int asInt = studentList.stream().filter(s -> s.getAge() != null).mapToInt(Student::getAge).min().orElse(-1);
        System.out.println("asInt = " + asInt);

        int asInt11 = studentList.stream().mapToInt(s -> s.getAge()==null ? 1 : s.getAge()).min().orElse(0);
        System.out.println("asInt11 = " + asInt11);



        // List<Integer> collect1 = studentList.stream().map(Student::getAge).filter(Objects::nonNull).collect(Collectors.toList());
        // Integer min = Collections.min(collect1);
        // System.out.println("min = " + min);

        // int asInt1 = studentList.stream().map(Student::getAge).filter(Objects::nonNull).mapToInt(Integer::intValue).min().orElse(0);
        // System.out.println("asInt1 = " + asInt1);
        //
        // Integer integer1 = studentList.stream().map(Student::getAge).filter(Objects::nonNull).min(Integer::compare).orElse(-1);
        // System.out.println("integer1 = " + integer1);
        //
        //
        // int asInt1111 = studentList.stream().map(Student::getAge).filter(Objects::nonNull).mapToInt(Integer::intValue).sum();
        // System.out.println("asInt1111 = " + asInt1111);

    }
}

@Data
@AllArgsConstructor
class Student {
    private String name;
    private Integer age;
    private Integer height;
}
