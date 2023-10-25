package com.isoft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("meeting_appointment")
public class MeetingAppointment {
    @TableId(value = "id", type = IdType.AUTO) // 指定主键字段和主键生成策略
    private Integer id;
    private String department;
    private String title;
    private String name;
    private Date start;
    private Date end;
    private String meetingNumber;
    private String contain;
    private String type;
    private String applyPerson;
}
