package com.xingxin.controller;

import com.xiaoju.uemc.tinyid.client.utils.TinyId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuxh
 * @date 2021/6/23
 */
@RestController
@RequestMapping("/tinyId")
public class TinyIdController {

    @GetMapping("one")
    public Long getOne() {
        return TinyId.nextId("test");
    }

    @GetMapping("list")
    public List<Long> getList() {
        return TinyId.nextId("test",100);
    }
}
