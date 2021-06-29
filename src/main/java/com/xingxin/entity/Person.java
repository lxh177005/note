package com.xingxin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuxh
 * @since 2021-06-28
 */
@TableName("person")
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "Id", type = IdType.INPUT)
    private Integer Id;

    @TableField("Email")
    private String Email;

    public Person() {
    }

    public Person(Integer id, String email) {
        Id = id;
        Email = email;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Person{" +
        "Id=" + Id +
        ", Email=" + Email +
        "}";
    }
}
