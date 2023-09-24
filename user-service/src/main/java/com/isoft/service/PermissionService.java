package com.isoft.service;

import com.isoft.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 用户根据id查询权限菜单列表
     * @param userId
     * @return
     */
    List<Permission> findPermissionListByUserId(Long userId);
}
