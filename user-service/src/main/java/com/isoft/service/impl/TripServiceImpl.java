package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.AbroadMapper;
import com.isoft.dao.TripMapper;
import com.isoft.entity.Abroad;
import com.isoft.entity.Trip;
import com.isoft.service.AbroadService;
import com.isoft.service.TripService;
import com.isoft.vo.query.AbroadQueryVo;
import com.isoft.vo.query.TripQueryVo;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl extends ServiceImpl<TripMapper, Trip> implements TripService {
    public IPage<Trip> findRoleListByUserId(IPage<Trip> page, TripQueryVo groupQueryVo) {
        QueryWrapper<Trip> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
