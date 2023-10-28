package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.EggSetMapper;
import com.isoft.dao.MaintainResultMapper;
import com.isoft.entity.EggSet;
import com.isoft.entity.MaintainResult;
import com.isoft.service.EggSetService;
import com.isoft.service.MaintainResultService;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.MaintainResultQueryVo;
import org.springframework.stereotype.Service;

@Service
public class EggSetServiceImpl extends ServiceImpl<EggSetMapper, EggSet> implements EggSetService {
    public IPage<EggSet> findRoleListByUserId(IPage<EggSet> page, EggSetQueryVo groupQueryVo) {
        QueryWrapper<EggSet> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"person",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
