package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.MaintainResultMapper;
import com.isoft.dao.TopUpMapper;
import com.isoft.entity.MaintainResult;
import com.isoft.entity.TopUp;
import com.isoft.service.MaintainResultService;
import com.isoft.service.TopUpService;
import com.isoft.vo.query.MaintainResultQueryVo;
import com.isoft.vo.query.TopUpQueryVo;
import org.springframework.stereotype.Service;

@Service
public class TopUpServiceImpl extends ServiceImpl<TopUpMapper, TopUp> implements TopUpService {
    public IPage<TopUp> findRoleListByUserId(IPage<TopUp> page, TopUpQueryVo groupQueryVo) {
        QueryWrapper<TopUp> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
