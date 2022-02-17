package com.xingxin.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuxh
 * @date 2021/7/14
 */
public class ForEachTest {
    @Data
    @AllArgsConstructor
    @ToString
    static class Student {
        private Integer id;
        private String name;
        private Score score;
    }

    @Data
    @AllArgsConstructor
    @ToString
    static class Score {
        private Integer id;
        private Integer score;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Score> scores = new ArrayList<>();
        students.add(new Student(1, "zhangsan", null));
        students.add(new Student(2, "lisi", null));
        students.add(new Student(3, "zhaowu", null));
        scores.add(new Score(1, 99));
        scores.add(new Score(2, 88));
        scores.add(new Score(3, 77));

        // 以关联条件作为map的k，必须是唯一的  效率高 推荐
        Map<Integer, Score> map = scores.stream().collect(Collectors.toMap(Score::getId, c -> c));
        students.forEach(s -> {
            s.setScore(map.get(s.getId()));
            System.out.println("s = " + s);
        });

        // 双层for循环 不建议使用
        students.forEach(student -> {
            scores.forEach(score -> {
                if (score.getId().equals(student.getId())) {
                    student.setScore(score);
                }
            });
            System.out.println("student = " + student);
        });


        //map遍历
        Map<String, String> map2 = new HashMap<>();
        map2.put("k1", "v1");
        map2.put("k2", "v2");
        map2.put("k3", "v3");
        map2.put("k4", "v4");
        map2.forEach((k, v) -> System.out.println(k + "," + v));
    }
}
