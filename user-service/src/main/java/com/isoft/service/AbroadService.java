package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Abroad;
import com.isoft.entity.EggSet;
import com.isoft.vo.query.AbroadQueryVo;
import com.isoft.vo.query.EggSetQueryVo;

public interface AbroadService extends IService<Abroad> {
    IPage<Abroad> findRoleListByUserId(IPage<Abroad> page, AbroadQueryVo groupQueryVo);
}
