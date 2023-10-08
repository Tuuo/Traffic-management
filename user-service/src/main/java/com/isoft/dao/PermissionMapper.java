package com.isoft.dao;

import com.isoft.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 用户根据id查询权限菜单列表
     * @param userId
     * @return
     */
    List<Permission> findPermissionListByUserId(Long userId);

    List<Permission> findPermissionListByRoleId(Long roleId);
}
