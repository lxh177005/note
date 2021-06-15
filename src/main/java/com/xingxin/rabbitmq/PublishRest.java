package com.xingxin.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/6/15
 */
@Slf4j
@RestController
public class PublishRest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("publish")
    public boolean publish(String exchange, String routing, String data) {
        log.info("publish params : exchange= {},routing = {},data = {}", exchange, routing, data);
        rabbitTemplate.convertAndSend(exchange, routing, data);
        return true;
    }
}
