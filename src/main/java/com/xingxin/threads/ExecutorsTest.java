package com.xingxin.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuxh
 * @date 2021/9/10
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            System.out.println("---------------------");
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + ":" + finalI));
            System.out.println("=====================");
        }
    }
}
