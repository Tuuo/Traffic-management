package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Abroad;
import com.isoft.entity.Trip;
import com.isoft.vo.query.AbroadQueryVo;
import com.isoft.vo.query.TripQueryVo;

public interface TripService extends IService<Trip> {
    IPage<Trip> findRoleListByUserId(IPage<Trip> page, TripQueryVo groupQueryVo);
}
