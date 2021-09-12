package com.xingxin.reflex;

import com.xingxin.annotation.XingxinName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author liuxh
 * @date 2021/9/12
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ReflexEntity {
    private String username;
    private Integer userAge;

    public String pubUsername;

    public ReflexEntity() {
        System.out.println("无参构造");
    }

    private ReflexEntity(String username, Integer userAge) {
        System.out.println("有参构造：username=" + username + " ,userAge=" + userAge);
        this.username = username;
        this.userAge = userAge;
    }

    @XingxinName
    private void hello() {
        System.out.println("私有方法：hello");
    }

    private Integer sum(Integer a, Integer b) {
        return a + b;
    }

    @Deprecated
    public void oldHello() {
        System.out.println("弃用的hello方法");
    }
}
