package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("basic_information") // 指定数据库表名
public class Basic_information  {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id;
    private String name;
    private String cardId;
    private String gender;
    private String birthday;
    private String education;
    private String birthplace;
    private String nation;
    private String politics;
    private String marriage;
}
