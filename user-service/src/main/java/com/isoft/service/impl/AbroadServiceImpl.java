package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.AbroadMapper;
import com.isoft.dao.EggSetMapper;
import com.isoft.entity.Abroad;
import com.isoft.entity.EggSet;
import com.isoft.service.AbroadService;
import com.isoft.service.EggSetService;
import com.isoft.vo.query.AbroadQueryVo;
import com.isoft.vo.query.EggSetQueryVo;
import org.springframework.stereotype.Service;

@Service
public class AbroadServiceImpl extends ServiceImpl<AbroadMapper, Abroad> implements AbroadService {
    public IPage<Abroad> findRoleListByUserId(IPage<Abroad> page, AbroadQueryVo groupQueryVo) {
        QueryWrapper<Abroad> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
