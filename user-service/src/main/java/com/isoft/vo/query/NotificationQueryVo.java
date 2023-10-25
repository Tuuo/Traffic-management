package com.isoft.vo.query;

import com.isoft.entity.Notification;
import lombok.Data;

@Data
public class NotificationQueryVo extends Notification {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
