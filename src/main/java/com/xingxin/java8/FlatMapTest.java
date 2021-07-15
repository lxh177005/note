package com.xingxin.java8;

import org.noggit.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * map 处理之后，list结构还是原来的，flatMap处理之后，list结果改为一级了
 * @author liuxh
 * @date 2021/7/15
 */
public class FlatMapTest {
    public static void main(String[] args) {
        //有二箱鸡蛋，每箱5个，现在要把鸡蛋加工成煎蛋，然后分给学生。
        //map做的事情：把二箱鸡蛋分别加工成煎蛋，还是放成原来的两箱，分给2组学生；
        //flatMap做的事情：把二箱鸡蛋分别加工成煎蛋，然后放到一起【10个煎蛋】，分给10个学生；
        List<List<String>> eggs = new ArrayList<>();
        eggs.add(Arrays.asList("鸡蛋1", "鸡蛋1", "鸡蛋1", "鸡蛋1", "鸡蛋1"));
        eggs.add(Arrays.asList("鸡蛋2", "鸡蛋2", "鸡蛋2", "鸡蛋2", "鸡蛋2"));
        // map处理过后，eggs结构还是 List<List<String>>
        eggs.stream()
                .map(egg -> egg.stream().map(e -> e.replace("鸡", "煎")))
                .forEach(egg -> egg.forEach(System.out::print) );

        // flatMap处理过后，eggs结构变为：List<String>
        eggs.stream()
                .flatMap(egg -> egg.stream().map(e -> e.replace("鸡", "煎")))
                .forEach(System.out::println);

    }
}
