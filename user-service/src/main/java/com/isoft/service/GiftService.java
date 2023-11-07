package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Gift;
import com.isoft.entity.Holiday;
import com.isoft.vo.query.GiftQueryVo;
import com.isoft.vo.query.HolidayQueryVo;

public interface GiftService extends IService<Gift> {
    IPage<Gift> findRoleListByUserId(IPage<Gift> page, GiftQueryVo groupQueryVo);
}
