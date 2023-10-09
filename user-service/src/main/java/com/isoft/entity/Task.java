package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tasks") // 指定数据库表名
public class Task {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id;

    private Long timestamp;

    private String title;

    private String content;

    private Boolean replied;

    // 你可以在这里添加构造函数、getter和setter方法
}
