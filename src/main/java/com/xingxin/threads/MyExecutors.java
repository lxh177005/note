package com.xingxin.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 手写线程池
 * <p>
 * 线程池的核心点：复用机制----
 * 1.提前创建好固定的线程数一直在运行状态--while死循环；
 * 2.任务缓存到并发队列中；
 * 3.正在运行的线程从队列中获取任务并执行；
 * 4.超过队列容量的任务根据拒绝策略决定。
 *
 * @author liuxh
 * @date 2021/9/10
 */
public class MyExecutors {

    private List<WorkThread> workThread;
    // 缓存线程任务；
    private BlockingDeque<Runnable> runnableDeque;
    // 开关
    private boolean isRun = true;

    /**
     * 最大线程数
     *
     * @param maxThreadCount
     */
    public MyExecutors(int maxThreadCount, int queueSize) {
        // 2.任务缓存到并发队列中；
        runnableDeque = new LinkedBlockingDeque<>(queueSize);
        // 1.提前创建好固定的线程数一直在运行状态--while死循环；
        workThread = new ArrayList<>(maxThreadCount);
        for (int i = 0; i < maxThreadCount; i++) {
            new WorkThread().start();

        }


    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (isRun || runnableDeque.size() > 0) {
                Runnable runnable = runnableDeque.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public boolean execute(Runnable command) {
        return runnableDeque.offer(command);
    }

    public static void main(String[] args) {
        MyExecutors myExecutors = new MyExecutors(2, 20);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            myExecutors.execute(() -> System.out.println(Thread.currentThread().getName() + "," + finalI));
        }
        myExecutors.isRun = false;
    }
}
