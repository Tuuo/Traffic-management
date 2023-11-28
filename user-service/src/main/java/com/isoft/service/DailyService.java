package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Daily;
import com.isoft.entity.EggSet;
import com.isoft.vo.query.DailyQueryVo;
import com.isoft.vo.query.EggSetQueryVo;

public interface DailyService extends IService<Daily> {
    IPage<Daily> findRoleListByUserId(IPage<Daily> page, DailyQueryVo groupQueryVo);
}
