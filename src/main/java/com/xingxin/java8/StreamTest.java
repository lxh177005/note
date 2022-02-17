package com.xingxin.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;


public class StreamTest {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("tom", 12, 200),
                new Student("jerry", 12, 100),
                new Student("kitty", 12, 30),
                new Student("david", 19, 15),
                new Student("lucy", 19, 100)
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
        studentList.sort(Comparator.comparing(Student::getHeight).reversed()
                .thenComparing(Student::getAge));
        studentList.forEach(System.out::println);

        // 取分组后最大、最小、平均、合值
        // 注意：要分组的值和比较的值不能出现null值，否则会npe
        Map<Integer, DoubleSummaryStatistics> map1 = studentList.stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.summarizingDouble(Student::getHeight)));
        map1.forEach((k, v) -> {
            long count = v.getCount();
            double max = v.getMax();
            double min = v.getMin();
            double average = v.getAverage();
            System.out.println("k=" + k + ",count=" + count + ",max=" + max + ",min=" + min + ",avg=" + average);
        });
    }
}

@Data
@AllArgsConstructor
class Student {
    private String name;
    private Integer age;
    private Integer height;
}
