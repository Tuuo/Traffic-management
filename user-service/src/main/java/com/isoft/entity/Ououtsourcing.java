package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("ououtsourcing")
public class Ououtsourcing {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id;
    private String name;
    private String school;
    private String specialty;
    private Date ououtStart;
    private Date ououtEnd;
    private String person;
    private String department;
    private String cardId;

}
