package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.MeetingMapper;
import com.isoft.dao.NotificationMapper;
import com.isoft.entity.Meeting;
import com.isoft.entity.Notification;
import com.isoft.service.MeetingService;
import com.isoft.service.NotificationService;
import com.isoft.vo.query.MeetingQueryVo;
import com.isoft.vo.query.NotificationQueryVo;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl extends ServiceImpl<MeetingMapper, Meeting> implements MeetingService {
    public IPage<Meeting> findRoleListByUserId(IPage<Meeting> page, MeetingQueryVo groupQueryVo) {
        QueryWrapper<Meeting> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
