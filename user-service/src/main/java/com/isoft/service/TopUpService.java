package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.MaintainResult;
import com.isoft.entity.TopUp;
import com.isoft.vo.query.MaintainResultQueryVo;
import com.isoft.vo.query.TopUpQueryVo;

public interface TopUpService extends IService<TopUp> {
    IPage<TopUp> findRoleListByUserId(IPage<TopUp> page, TopUpQueryVo groupQueryVo);
}
