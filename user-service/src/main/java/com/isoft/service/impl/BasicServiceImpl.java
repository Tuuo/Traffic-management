package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.BasicMapper;
import com.isoft.dao.DepartmentMapper;
import com.isoft.entity.Basic_information;
import com.isoft.entity.Department;
import com.isoft.service.BasicService;
import com.isoft.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl extends ServiceImpl<BasicMapper, Basic_information> implements BasicService {
    @Override
    public Basic_information findBasicById(Integer id) {
        baseMapper.findById(id);
        return null;

    }

    @Override
    public boolean updateBasic(Basic_information basicInformation) {
        return baseMapper.updateBasic(basicInformation);
    }
}
