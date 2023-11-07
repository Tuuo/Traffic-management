package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Holiday;
import com.isoft.entity.Return;
import com.isoft.vo.query.HolidayQueryVo;
import com.isoft.vo.query.ReturnQueryVo;

public interface HolidayService extends IService<Holiday> {
    IPage<Holiday> findRoleListByUserId(IPage<Holiday> page, HolidayQueryVo groupQueryVo);
}
