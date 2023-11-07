package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.EggSetMapper;
import com.isoft.dao.ReturnMapper;
import com.isoft.entity.EggSet;
import com.isoft.entity.Return;
import com.isoft.service.EggSetService;
import com.isoft.service.ReturnService;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.ReturnQueryVo;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl extends ServiceImpl<ReturnMapper, Return> implements ReturnService {
    public IPage<Return> findRoleListByUserId(IPage<Return> page, ReturnQueryVo groupQueryVo) {
        QueryWrapper<Return> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(groupQueryVo.getPerson()),"person",groupQueryVo.getPerson());
        //排序
        queryWrapper.orderByAsc("id");
//        queryWrapper.eq("create_user",groupQueryVo.getId());
        return baseMapper.selectPage(page,queryWrapper);
    }
}
