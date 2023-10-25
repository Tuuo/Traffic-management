package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.GroupMapper;
import com.isoft.dao.NotificationMapper;
import com.isoft.entity.Group;
import com.isoft.entity.Notification;
import com.isoft.service.GroupService;
import com.isoft.service.NotificationService;
import com.isoft.vo.query.GroupQueryVo;
import com.isoft.vo.query.NotificationQueryVo;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification> implements NotificationService {
    public IPage<Notification> findRoleListByUserId(IPage<Notification> page, NotificationQueryVo groupQueryVo) {
        QueryWrapper<Notification> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getTitle()),"title",groupQueryVo.getTitle());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
