package com.xingxin;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
class NoteApplicationTests {

    @Test
    void contextLoads() {
    }

    @Data
    class User{
        public User() {
        }
        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }
        public User(String userName, int age, String info) {
            this.userName = userName;
            this.age = age;
            this.info = info;
        }

        private String userName;
        private int age;
        private String info;
    }

    @Test
    public void test(){
        List<User> userListA = Arrays.asList(
                new User("关羽", 666),
                new User("赵云", 666),
                new User("张飞", 666),
                new User("刘备", 666));
        List<User> userListB = Arrays.asList(
                new User("关羽", 999, "武财神"),
                new User("关云长", 999, "忠义"),
                new User("关公", 999, "汉寿亭侯"),
                new User("赵子龙", 999, "永昌亭侯"));

        List<String> commonList = userListA.stream()
                .map((uA) -> {
                    return userListB.stream()
                            .filter((uB) -> {
                                return StringUtils.equals(uB.getUserName(), uA.getUserName());
                            })
                            .map((uB) -> {
                                return uB.getUserName() + "_" + uA.age + "_" +uB.getInfo();
                            })
                            .collect(Collectors.toList());
                }) // 结果类型 Steam<List<String>>
                .flatMap(List::stream) // 结果类型 Steam<String>
                .collect(Collectors.toList()); // 结果类型 List<String>

//        System.out.println(JsonUtils.objectToJson(commonList)); // ["关羽_666_武财神"]
    }

}
