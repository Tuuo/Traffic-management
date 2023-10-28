package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.MaintainMapper;
import com.isoft.dao.MeetingAppointmentMapper;
import com.isoft.entity.Maintain;
import com.isoft.entity.MeetingAppointment;
import com.isoft.service.MaintainService;
import com.isoft.service.MeetingAppointmentService;
import com.isoft.vo.query.MaintainQueryVo;
import com.isoft.vo.query.MeetingAppointmentQueryVo;
import org.springframework.stereotype.Service;

@Service
public class MaintainServiceImpl extends ServiceImpl<MaintainMapper, Maintain> implements MaintainService {
    public IPage<Maintain> findRoleListByUserId(IPage<Maintain> page, MaintainQueryVo groupQueryVo) {
        QueryWrapper<Maintain> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getPerson()),"person",groupQueryVo.getPerson());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
