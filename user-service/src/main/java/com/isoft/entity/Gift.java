package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("gift")
public class Gift {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id;
    private String name;
    private Date giftDate;
    private String person;
}
