package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.MeetingAppointmentMapper;
import com.isoft.dao.MeetingMapper;
import com.isoft.entity.Meeting;
import com.isoft.entity.MeetingAppointment;
import com.isoft.service.MeetingAppointmentService;
import com.isoft.service.MeetingService;
import com.isoft.vo.query.MeetingAppointmentQueryVo;
import com.isoft.vo.query.MeetingQueryVo;
import org.springframework.stereotype.Service;

@Service
public class MeetingAppointmentServiceImpl extends ServiceImpl<MeetingAppointmentMapper, MeetingAppointment> implements MeetingAppointmentService {
    public IPage<MeetingAppointment> findRoleListByUserId(IPage<MeetingAppointment> page, MeetingAppointmentQueryVo groupQueryVo) {
        QueryWrapper<MeetingAppointment> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getTitle()),"title",groupQueryVo.getTitle());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
