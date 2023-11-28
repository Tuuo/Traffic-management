package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.DailySetMapper;
import com.isoft.dao.EggSetMapper;
import com.isoft.entity.Daily;
import com.isoft.entity.EggSet;
import com.isoft.service.DailyService;
import com.isoft.service.EggSetService;
import com.isoft.vo.query.DailyQueryVo;
import com.isoft.vo.query.EggSetQueryVo;
import org.springframework.stereotype.Service;

@Service
public class DailyServiceImpl extends ServiceImpl<DailySetMapper, Daily> implements DailyService {
    public IPage<Daily> findRoleListByUserId(IPage<Daily> page, DailyQueryVo groupQueryVo) {
        QueryWrapper<Daily> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
