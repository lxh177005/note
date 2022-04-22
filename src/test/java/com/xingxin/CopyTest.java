package com.xingxin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author liuxh
 * @date 2021/11/4
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CopyTest {

    @Resource
    private MapperFacade mapperFacade;

    @Test
    public void copyTest() {
        User user = new User("1", "zhangsan", 18);
        UserDto userDto = mapperFacade.map(new User(), UserDto.class);
        System.out.println("userDto = " + userDto);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private String userId;
        private String userName;
        private Integer age;
    }
    @Data
    public static class UserDto {
        private String userId;
        private String userName;
        private Integer age;
    }
}
