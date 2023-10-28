package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Maintain;
import com.isoft.entity.MaintainResult;
import com.isoft.vo.query.MaintainQueryVo;
import com.isoft.vo.query.MaintainResultQueryVo;

public interface MaintainResultService extends IService<MaintainResult> {
    IPage<MaintainResult> findRoleListByUserId(IPage<MaintainResult> page, MaintainResultQueryVo groupQueryVo);
}
