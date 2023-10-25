package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Basic_information;
import com.isoft.entity.Group;
import com.isoft.entity.Notification;
import com.isoft.vo.query.GroupQueryVo;
import com.isoft.vo.query.NotificationQueryVo;

public interface NotificationService  extends IService<Notification> {
    IPage<Notification> findRoleListByUserId(IPage<Notification> page, NotificationQueryVo groupQueryVo);
}
