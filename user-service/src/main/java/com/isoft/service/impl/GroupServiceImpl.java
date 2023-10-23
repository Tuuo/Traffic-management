package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.BasicMapper;
import com.isoft.dao.GroupMapper;
import com.isoft.entity.Basic_information;
import com.isoft.entity.Group;
import com.isoft.entity.Role;
import com.isoft.entity.User;
import com.isoft.service.BasicService;
import com.isoft.service.GroupService;
import com.isoft.vo.query.GroupQueryVo;

public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {
    @Override
    public IPage<Group> findRoleListByUserId(IPage<Group> page, GroupQueryVo groupQueryVo) {
        QueryWrapper<Group> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getGroupName()),"group_name",groupQueryVo.getGroupName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
