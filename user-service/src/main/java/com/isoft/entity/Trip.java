package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("business_trip")
public class Trip {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id;
    private String name;
    private Date tripDate;
    private Date returnDate;
    private String reason;
    private String location;
    private String tripDay;
}
