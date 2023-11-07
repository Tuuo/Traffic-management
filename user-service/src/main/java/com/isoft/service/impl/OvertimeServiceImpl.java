package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.HolidayMapper;
import com.isoft.dao.OvertimeMapper;
import com.isoft.entity.Holiday;
import com.isoft.entity.Overtime;
import com.isoft.service.HolidayService;
import com.isoft.service.OvertimeService;
import com.isoft.vo.query.HolidayQueryVo;
import com.isoft.vo.query.OvertimeQueryVo;
import org.springframework.stereotype.Service;

@Service
public class OvertimeServiceImpl extends ServiceImpl<OvertimeMapper, Overtime> implements OvertimeService {
    public IPage<Overtime> findRoleListByUserId(IPage<Overtime> page, OvertimeQueryVo groupQueryVo) {
        QueryWrapper<Overtime> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
