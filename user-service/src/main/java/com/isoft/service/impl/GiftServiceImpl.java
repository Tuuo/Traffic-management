package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.GiftMapper;
import com.isoft.dao.HolidayMapper;
import com.isoft.entity.Gift;
import com.isoft.entity.Holiday;
import com.isoft.service.GiftService;
import com.isoft.service.HolidayService;
import com.isoft.vo.query.GiftQueryVo;
import com.isoft.vo.query.HolidayQueryVo;
import org.springframework.stereotype.Service;

@Service
public class GiftServiceImpl extends ServiceImpl<GiftMapper, Gift> implements GiftService {
    public IPage<Gift> findRoleListByUserId(IPage<Gift> page, GiftQueryVo groupQueryVo) {
        QueryWrapper<Gift> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getName()),"name",groupQueryVo.getName());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
