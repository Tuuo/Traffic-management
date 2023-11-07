package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.ConnectMapper;
import com.isoft.dao.DimissionMapper;
import com.isoft.entity.Connect;
import com.isoft.entity.Dimission;
import com.isoft.service.ConnectService;
import com.isoft.service.DimissionService;
import com.isoft.vo.query.ConnectQueryVo;
import com.isoft.vo.query.DimissionQueryVo;
import org.springframework.stereotype.Service;

@Service
public class DimissionServiceImpl extends ServiceImpl<DimissionMapper, Dimission> implements DimissionService {
    public IPage<Dimission> findRoleListByUserId(IPage<Dimission> page, DimissionQueryVo groupQueryVo) {
        QueryWrapper<Dimission> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
