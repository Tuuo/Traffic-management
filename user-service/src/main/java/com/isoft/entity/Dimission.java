package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("dimission")
public class Dimission {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id;
    private String department;
    private String name;
    private String cardId;
    private String specialty;
    private String gender;
    private Date startDate;
    private Date endDate;

}
