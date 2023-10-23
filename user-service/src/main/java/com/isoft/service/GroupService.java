package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Family;
import com.isoft.entity.Group;
import com.isoft.entity.Role;
import com.isoft.vo.query.GroupQueryVo;

public interface GroupService extends IService<Group> {
    IPage<Group> findRoleListByUserId(IPage<Group> page, GroupQueryVo groupQueryVo);
}
