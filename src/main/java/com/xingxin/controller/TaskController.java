package com.xingxin.controller;


import com.xingxin.annotation.XingxinName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author liuxh
 * @date 2021/6/11
 */
@Slf4j
@RestController
@RequestMapping("/task")
@XingxinName
public class TaskController {

    @XingxinName
    private String userName;

    @GetMapping("/good")
    @Scheduled(cron = "0 30/10 10,14,18,22 ? * 2,4,6")
    @XingxinName
    public void goodLuck() {
        LocalDateTime now = LocalDateTime.now();
        log.info("info={}",  now);
        log.debug("debug={}", now);
        log.error("error={}", now);
        log.warn("warn is {}", now);
    }
}
