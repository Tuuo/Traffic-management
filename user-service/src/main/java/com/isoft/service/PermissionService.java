package com.isoft.service;

import com.isoft.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.vo.query.PermissionQueryVo;

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
    /**
     * 查询菜单列表
     * @param permissionQueryVo
     * @return
     */
    List<Permission> findPermissionList(PermissionQueryVo permissionQueryVo);

    /**
     * 查询上级此菜单
     * @return
     */
    List<Permission> findParentPermissionList();
    /**
     * 检查菜单是否有子菜单
     * @param id
     * @return
     */
    boolean hasChildrenOfPermission(Long id);
}
