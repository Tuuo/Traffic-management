package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Holiday;
import com.isoft.entity.SummaryTime;
import com.isoft.vo.query.HolidayQueryVo;
import com.isoft.vo.query.SummaryTimeQueryVo;

public interface SummaryTimeService extends IService<SummaryTime> {
    IPage<SummaryTime> findRoleListByUserId(IPage<SummaryTime> page, SummaryTimeQueryVo groupQueryVo);
}
