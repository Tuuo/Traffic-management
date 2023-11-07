package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Connect;
import com.isoft.entity.Dimission;
import com.isoft.vo.query.ConnectQueryVo;
import com.isoft.vo.query.DimissionQueryVo;

public interface DimissionService extends IService<Dimission> {
    IPage<Dimission> findRoleListByUserId(IPage<Dimission> page, DimissionQueryVo groupQueryVo);
}
