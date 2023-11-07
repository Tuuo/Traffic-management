package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.EggSetMapper;
import com.isoft.dao.OuoutsourcingMapper;
import com.isoft.entity.EggSet;
import com.isoft.entity.Ououtsourcing;
import com.isoft.service.EggSetService;
import com.isoft.service.OuoutsourcingService;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.OuoutsourcingQueryVo;
import org.springframework.stereotype.Service;

@Service
public class OuoutsourcingServiceImpl extends ServiceImpl<OuoutsourcingMapper, Ououtsourcing> implements OuoutsourcingService {
    public IPage<Ououtsourcing> findRoleListByUserId(IPage<Ououtsourcing> page, OuoutsourcingQueryVo groupQueryVo) {
        QueryWrapper<Ououtsourcing> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
