package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.EggSet;
import com.isoft.entity.Return;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.ReturnQueryVo;

public interface ReturnService extends IService<Return> {
    IPage<Return> findRoleListByUserId(IPage<Return> page, ReturnQueryVo groupQueryVo);
}
