package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Connect;
import com.isoft.entity.Holiday;
import com.isoft.vo.query.ConnectQueryVo;
import com.isoft.vo.query.HolidayQueryVo;

public interface ConnectService extends IService<Connect> {
    IPage<Connect> findRoleListByUserId(IPage<Connect> page, ConnectQueryVo groupQueryVo);
}
