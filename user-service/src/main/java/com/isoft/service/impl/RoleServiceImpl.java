package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.isoft.dao.UserMapper;
import com.isoft.entity.Role;
import com.isoft.dao.RoleMapper;
import com.isoft.entity.User;
import com.isoft.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.vo.query.RoleQueryVo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private UserMapper userMapper;
    /**
     * 根据用户查询角色列表
     * @param page
     * @param roleQueryVo
     * @return
     */
    @Override
    public IPage<Role> findRoleListByUserId(IPage<Role> page, RoleQueryVo roleQueryVo) {
        //创建条件构造器
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        //角色名称
        queryWrapper.like(!ObjectUtils.isEmpty(roleQueryVo.getRoleName()),"role_name",roleQueryVo.getRoleName());
        //排序
        queryWrapper.orderByAsc("id");
        //根据用户ID查询用户信息
        User user = userMapper.selectById(roleQueryVo.getUserId());

        //如果用户不为空，且不是管理员，则只能查询自己创建的角色
        if(user!=null && !ObjectUtils.isEmpty(user.getIsAdmin())&& user.getIsAdmin() !=1){
            queryWrapper.eq("create_user",roleQueryVo.getUserId());
        }
        return baseMapper.selectPage(page,queryWrapper);
    }

    @Override
    public boolean hashRoleCount(Long id) {
        return baseMapper.getRoleCountByRoleId(id)>0;
    }

    @Override
    public boolean deleteRoleById(Long id) {
        //删除角色权限关系
        baseMapper.deleteRolePermissionByRoleId(id);
        //删除角色
        return baseMapper.deleteById(id)>0;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean saveRolePermission(Long roleId, List<Long> permissionIds) {
        //删除该角色对应的权限信息
        baseMapper.deleteRolePermission(roleId);
        //保存角色信息
        return baseMapper.saveRolePermission(roleId,permissionIds) >0;
    }

    @Override
    public Role findRoleByName(String roleName) {
        Role role = baseMapper.getRoleByName(roleName);
        return role;
    }
    /**
     * 根据用户ID查询该用户拥有的角色ID
     *
     * @param userId
     * @return
     */
    @Override
    public List<Long> findRoleIdByUserId(Long userId) {
        return baseMapper.findRoleIdByUserId(userId);
    }

}
