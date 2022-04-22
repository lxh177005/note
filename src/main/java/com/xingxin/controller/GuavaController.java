package com.xingxin.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.xingxin.annotation.XingxinCurrentLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/9/12
 */
@RestController
@RequestMapping("/guava")
@XingxinCurrentLimit(name = "get", token = 1.0)
public class GuavaController {

//    private RateLimiter rateLimiter = RateLimiter.create(2.0);

    @GetMapping("/get")
    // @XingxinCurrentLimit(name = "get", token = 1.0)
    public String get() {
//        boolean acquire = rateLimiter.tryAcquire();
//        if (!acquire) {
//            return "outpace limit, please wait...";
//        }
        return "get success";
    }

    @GetMapping("/add")
    @XingxinCurrentLimit(name = "add", token = 10.0)
    public String add() {
        return "add success";
    }

    @GetMapping("/my")
    public String my() {
        return "my";
    }
}
