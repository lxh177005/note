package com.xingxin.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxh
 * @date 2021/10/27
 */
public class ListTest {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);

//        // 并集
//        list1.retainAll(list2);
//        System.out.println("list1 = " + list1);

        // 差集
//        list1.removeAll(list2);
//        list1.addAll(list2);
//        System.out.println("list1 = " + list1);

        // 差集
        list1.removeAll(list2);
        System.out.println("list1 = " + list1);


    }
}
