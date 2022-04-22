package com.xingxin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dagege
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 核心数
     */
    private int corePoolSize = 4;

    /**
     * 最大线程数
     */
    private int maxPoolSize = 8;

    /**
     * 任务队列长度
     */
    private int queueCapacity = 1000;

    /**
     * 非核心线程存活事件
     */
    private int keepAliveSeconds = 300;

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(maxPoolSize);
        executor.setCorePoolSize(corePoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 线程池对拒绝任务(无线程可用)的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
