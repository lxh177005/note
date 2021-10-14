package com.xingxin.controller;


import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.xingxin.annotation.XingxinName;
import com.xingxin.utils.QRCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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

    @GetMapping(value = "/test")

    public void getCode(String url , HttpServletResponse response) throws IOException {
        // 设置响应流信息
        response.setContentType("image/jpg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        OutputStream stream = response.getOutputStream();

        //type是1，生成活动详情、报名的二维码，type是2，生成活动签到的二维码
        //获取一个二维码图片
        BitMatrix bitMatrix = QRCodeUtils.createCode(url);
        //以流的形式输出到前端
        MatrixToImageWriter.writeToStream(bitMatrix , "jpg" , stream);
    }
}
