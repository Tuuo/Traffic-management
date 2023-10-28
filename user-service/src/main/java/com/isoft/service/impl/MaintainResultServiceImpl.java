package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.MaintainMapper;
import com.isoft.dao.MaintainResultMapper;
import com.isoft.entity.Maintain;
import com.isoft.entity.MaintainResult;
import com.isoft.service.MaintainResultService;
import com.isoft.service.MaintainService;
import com.isoft.vo.query.MaintainQueryVo;
import com.isoft.vo.query.MaintainResultQueryVo;
import org.springframework.stereotype.Service;

@Service
public class MaintainResultServiceImpl extends ServiceImpl<MaintainResultMapper, MaintainResult> implements MaintainResultService {
    public IPage<MaintainResult> findRoleListByUserId(IPage<MaintainResult> page, MaintainResultQueryVo groupQueryVo) {
        QueryWrapper<MaintainResult> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getPerson()),"person",groupQueryVo.getPerson());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
