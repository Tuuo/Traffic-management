package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Holiday;
import com.isoft.entity.Overtime;
import com.isoft.vo.query.HolidayQueryVo;
import com.isoft.vo.query.OvertimeQueryVo;

public interface OvertimeService extends IService<Overtime> {
    IPage<Overtime> findRoleListByUserId(IPage<Overtime> page, OvertimeQueryVo groupQueryVo);
}
