package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.EggSet;
import com.isoft.entity.Ououtsourcing;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.OuoutsourcingQueryVo;

public interface OuoutsourcingService extends IService<Ououtsourcing> {
    IPage<Ououtsourcing> findRoleListByUserId(IPage<Ououtsourcing> page, OuoutsourcingQueryVo groupQueryVo);
}
