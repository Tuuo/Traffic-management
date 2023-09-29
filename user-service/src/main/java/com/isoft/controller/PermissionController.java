package com.isoft.controller;


import com.isoft.entity.Permission;
import com.isoft.service.PermissionService;
import com.isoft.utils.Result;
import com.isoft.vo.query.PermissionQueryVo;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
@RestController
//@CrossOrigin
@RequestMapping("/api/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    /**
     * ]
     * 查询菜单列表
     *
     * @param permissionQueryVo
     * @return
     */
    @GetMapping("/list")
    public Result getMenuList(PermissionQueryVo permissionQueryVo) {
        //查询菜单列表
        List<Permission> permissionList = permissionService.findPermissionList(permissionQueryVo);
        return Result.ok(permissionList);
    }

    /**
     * 查询上级菜单
     *
     * @return
     */
    @GetMapping("/parent/list")
    public Result getParentList() {
        List<Permission> parentPermissionList = permissionService.findParentPermissionList();
        return Result.ok(parentPermissionList);
    }

    /**
     * 根据id查询信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getMenuById(@PathVariable("id") Long id) {
        return Result.ok(permissionService.findPermissionListByUserId(id));
    }

    @PostMapping("/add")
    public Result add(@RequestBody Permission permission) {
        if (permissionService.save(permission)) {
            return Result.ok().message("菜单添加成功");
        }
        return Result.error().message("菜单添加失败");
    }

    /**
     * 修改菜单
     *
     * @param permission
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Permission permission) {
        if (permissionService.updateById(permission)) {
            return Result.ok().message("菜单修改成功");
        }
        return Result.error().message("菜单修改失败");
    }

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        if (permissionService.removeById(id)) {
            return Result.ok().message("菜单删除成功");
        }
        return Result.error().message("菜单删除失败");
    }

    /**
     * 检查菜单下是否有子菜单
     *
     * @param id
     * @return
     */
    @GetMapping("/check/{id}")
    public Result check(@PathVariable Long id) {
         //判断菜单是否有子菜单
        if (permissionService.hasChildrenOfPermission(id)) {
            return Result.exist().message("该菜单下有子菜单，无法删除");
        }
        return Result.ok();
    }


}

