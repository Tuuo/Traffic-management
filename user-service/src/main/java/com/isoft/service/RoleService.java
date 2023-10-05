package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.isoft.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.vo.query.RoleQueryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户查询角色列表
     * @param page
     * @param roleQueryVo
     * @return
     */
    IPage<Role> findRoleListByUserId(IPage<Role> page, RoleQueryVo roleQueryVo);

    /**
     * 检查角色是否被使用
     * @param id
     * @return
     */
    boolean hashRoleCount(Long id);

    /**
     * 删除角色
     * @param id
     * @return
     */
    boolean deleteRoleById(Long id);
}
