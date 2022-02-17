package com.xingxin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author liuxh
 * @date 2022/2/15
 */
@Data
public class User {

    private static final long serialVersionUID= 6248247155657730443L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
}
