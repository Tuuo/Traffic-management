package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.EggSet;
import com.isoft.entity.MaintainResult;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.MaintainResultQueryVo;

public interface EggSetService extends IService<EggSet> {
    IPage<EggSet> findRoleListByUserId(IPage<EggSet> page, EggSetQueryVo groupQueryVo);
}
