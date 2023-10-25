package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Meeting;
import com.isoft.entity.Notification;
import com.isoft.vo.query.MeetingQueryVo;
import com.isoft.vo.query.NotificationQueryVo;

public interface MeetingService extends IService<Meeting> {
    IPage<Meeting> findRoleListByUserId(IPage<Meeting> page, MeetingQueryVo groupQueryVo);
}
