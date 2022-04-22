package com.xingxin;

import com.xiaoju.uemc.tinyid.client.utils.TinyId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liuxh
 * @date 2021/6/24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TinyIdTest {

    @Test
    public void tinyidTest() {
        Long id = TinyId.nextId("test");
        System.out.println("id = " + id);
    }

    @Test
    public void tinyidTest1() {
        List<Long> ids = TinyId.nextId("test", 10000);
        ids.forEach(System.out::println);
    }

}
