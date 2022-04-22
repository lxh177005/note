package com.xingxin.threads;

/**
 * @author liuxh
 * @date 2021/11/7
 */
public class ThreadCount implements Runnable{

    private int num = 100;

    @Override
    public void run() {
        while (true) {
            if (num > 1) {
                try {
                    // 运行状态->休眠状态
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 修饰代码块，加锁，拿到锁的执行，没拿到锁的就等待获取锁。
                synchronized (this) {
                    num--;
                    System.out.println(Thread.currentThread().getName() + ", num=" + num);
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadCount threadCount = new ThreadCount();
        Thread thread1 = new Thread(threadCount);
        Thread thread2 = new Thread(threadCount);
        thread1.start();
        thread2.start();
    }
}
