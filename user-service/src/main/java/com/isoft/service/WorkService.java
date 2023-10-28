package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.EggSet;
import com.isoft.entity.Work;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.WorkQueryVo;

public interface WorkService extends IService<Work> {
    IPage<Work> findRoleListByUserId(IPage<Work> page, WorkQueryVo groupQueryVo);
}
