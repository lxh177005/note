package com.xingxin.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingxin.dao.CinemaMapper;
import com.xingxin.entity.Cinema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuxh
 * @date 2021/12/11
 */
@Component
public class TestManager {

    @Resource
    private CinemaMapper cinemaMapper;

    private void init() {
        List<Cinema> cinemas = cinemaMapper.selectList(new LambdaQueryWrapper<>());
        System.out.println(cinemas);
        System.out.println("init......");
    }

    private void shutdown() {
        System.out.println("shutdown.....");
    }

    @PostConstruct
    public void start() {
        init();
    }

    @PreDestroy
    private void stop() {
        shutdown();
    }
}
