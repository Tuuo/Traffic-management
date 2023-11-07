package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.HolidayMapper;
import com.isoft.dao.SummaryTimeMapper;
import com.isoft.entity.Holiday;
import com.isoft.entity.SummaryTime;
import com.isoft.service.HolidayService;
import com.isoft.service.SummaryTimeService;
import com.isoft.vo.query.HolidayQueryVo;
import com.isoft.vo.query.SummaryTimeQueryVo;
import org.springframework.stereotype.Service;

@Service
public class SummaryTimeServiceImpl extends ServiceImpl<SummaryTimeMapper, SummaryTime> implements SummaryTimeService {
    public IPage<SummaryTime> findRoleListByUserId(IPage<SummaryTime> page, SummaryTimeQueryVo groupQueryVo) {
        QueryWrapper<SummaryTime> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getTitle()),"title",groupQueryVo.getTitle());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
