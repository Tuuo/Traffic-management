package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.entity.Permission;
import com.isoft.dao.PermissionMapper;
import com.isoft.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.utils.MenuTree;
import com.isoft.vo.query.PermissionQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public List<Permission> findPermissionListByUserId(Long userId) {
        return baseMapper.findPermissionListByUserId(userId);
    }

    /**
     * 查询菜单列表
     *
     * @return
     */
    @Override
    public List<Permission> findPermissionList(PermissionQueryVo permissionQueryVo) {
        //创建条件构造器对象
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        //排序
        queryWrapper.orderByAsc("order_num");
        //调用查询菜单列表的方法
        List<Permission> permissionList = baseMapper.selectList(queryWrapper);
        //生成菜单树
        List<Permission> menuTree = MenuTree.makeMenuTree(permissionList, 0L);

        return menuTree;
    }


    /**
     * 查询上级菜单列表
     *
     * @return
     */
    @Override
    public List<Permission> findParentPermissionList() {
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        //只查询type为目录和菜单的数据（type=0或type=1）
        queryWrapper.in("type", Arrays.asList(0, 1));
        //排序
        queryWrapper.orderByAsc("order_num");
        //查询菜单数据
        List<Permission> permissionList = baseMapper.selectList(queryWrapper);
        //构造顶级菜单信息，如果数据库中的菜单表没有数据，选择上级菜单时则显示顶级菜单
        Permission permission = new Permission();
        permission.setId(0L);
        permission.setParentId(-1L);
        permission.setLabel("顶级菜单");
        permissionList.add(permission);//将顶级菜单添加到集合
        //生成菜单数据
        List<Permission> menuTree = MenuTree.makeMenuTree(permissionList, -1L);
        return menuTree;
    }

    /**
     * 检查菜单是否有子菜单
     *
     * @param id
     * @return
     */
    @Override
    public boolean hasChildrenOfPermission(Long id) {
        //创建条件构造器对象
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<Permission>();
        //查询父级ID
        queryWrapper.eq("parent_id", id);
        //判断数量是否大于0，如果大于0则表示存在
        if (baseMapper.selectCount(queryWrapper) > 0) {
            return true;
        }
        return false;
    }

}
