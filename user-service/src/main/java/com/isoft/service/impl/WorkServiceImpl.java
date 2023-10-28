package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.EggSetMapper;
import com.isoft.dao.WorkMapper;
import com.isoft.entity.EggSet;
import com.isoft.entity.Work;
import com.isoft.service.EggSetService;
import com.isoft.service.WorkService;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.WorkQueryVo;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {
    public IPage<Work> findRoleListByUserId(IPage<Work> page, WorkQueryVo groupQueryVo) {
        QueryWrapper<Work> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getPerson()),"person",groupQueryVo.getPerson());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
