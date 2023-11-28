package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("daily")
public class Daily {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id; // 数据表的ID字段，自动生成

    private Date inDate; // 入库日期

    private String department; // 部门

    private String name; // 名称

    private String reason; // 原因

    private String price; // 价格

}
