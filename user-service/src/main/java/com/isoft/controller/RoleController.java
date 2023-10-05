package com.isoft.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.Role;
import com.isoft.service.RoleService;
import com.isoft.utils.Result;
import com.isoft.vo.query.RoleQueryVo;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
@RestController
//@CrossOrigin
@RequestMapping("/api/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    /**
     * 分页查询角色列表
     */
    @GetMapping("/list")
    public Result list(RoleQueryVo roleQueryVo){
        //创建分页对象
        IPage<Role> page = new Page<Role>(roleQueryVo.getPageNo(),roleQueryVo.getPageSize());
        //调用分页查询方法
        roleService.findRoleListByUserId(page,roleQueryVo);
        //返回数据
        return Result.ok(page);
    }
    /**
     * 添加角色
     */
    @PostMapping("/add")
    public Result add(@RequestBody Role role){
        if (roleService.save(role)){
            return Result.ok().message("角色添加成功");
        }
        return Result.error().message("角色添加失败");

    }
    /**
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Role role){
        if(roleService.updateById(role)){
            return Result.ok().message("角色修改成功");
        }
        return Result.error().message("角色修改失败");
    }
    /**
     * 删除角色
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        if(roleService.deleteRoleById(id)){
            return Result.ok().message("角色删除成功");
        }
        return Result.error().message("角色删除失败");
    }

    /**
     * 检查用户角色是否被使用
     * @param id
     * @return
     */
    @GetMapping("/check/{id}")
    public Result check(@PathVariable Long id){
        if(roleService.hashRoleCount(id)){
            return Result.exist().message("该角色已分配给其他用户");
        }
        return Result.ok();
    }
}

