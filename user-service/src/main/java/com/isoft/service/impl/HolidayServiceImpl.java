package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.HolidayMapper;
import com.isoft.dao.ReturnMapper;
import com.isoft.entity.Holiday;
import com.isoft.entity.Return;
import com.isoft.service.HolidayService;
import com.isoft.service.ReturnService;
import com.isoft.vo.query.HolidayQueryVo;
import com.isoft.vo.query.ReturnQueryVo;
import org.springframework.stereotype.Service;

@Service
public class HolidayServiceImpl extends ServiceImpl<HolidayMapper, Holiday> implements HolidayService {
    public IPage<Holiday> findRoleListByUserId(IPage<Holiday> page, HolidayQueryVo groupQueryVo) {
        QueryWrapper<Holiday> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
