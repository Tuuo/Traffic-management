package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("card_return")
public class Return {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id;
    private Date getDate;
    private String person;
    private String contain;
    private String returnDate;
}
