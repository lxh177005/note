package com.xingxin.threads;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liuxh
 * @date 2021/9/10
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        strings.add("xiaoai");
        strings.add("xiaohei");
        strings.add("xiaohong");
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
    }
}
