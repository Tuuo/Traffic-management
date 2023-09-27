package com.isoft.controller;


import com.isoft.entity.Department;
import com.isoft.service.DepartmentService;
import com.isoft.utils.Result;
import com.isoft.vo.query.DepartmentQueryVo;
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
@RequestMapping("/api/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 查询部门列表
     *
     * @param departmentQueryVo
     * @return
     */
    @GetMapping("/list")
    public Result list(DepartmentQueryVo departmentQueryVo) {
        List<Department> departmentList = departmentService.findDepartmentList(departmentQueryVo);
        return Result.ok(departmentList);
    }

    /**
     * 查询上级部门列表
     *
     * @return
     */
    @GetMapping("/parent/list")
    public Result getParentDepartment() {
        List<Department> departmentList = departmentService.findParentDepartment();
        return Result.ok(departmentList);
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
        if (departmentService.save(department)) {
            return Result.ok().message("部门添加成功");
        }
        return Result.error().message("部门添加失败");
    }

    /**
     * 修改部门
     *
     * @param department
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Department department) {
        if (departmentService.updateById(department)) {
            return Result.ok().message("部门修改成功");
        }
        return Result.error().message("部门修改失败");
    }

    /**
     * 查询某个部门下是否存在子部门
     *
     * @param id
     * @return
     */
    @GetMapping("/check/{id}")
    public Result check(@PathVariable Long id) {
        //调用查询部门下是否存在子部门的方法
        if (departmentService.hasChildrenOfDepartment(id)) {
            return Result.exist().message("该部门下存在子部门，无法删除");
        }
        //调用查询部门下是否存在用户的方法
        if (departmentService.hasUserOfDepartment(id)) {
            return Result.exist().message("该部门下存在用户，无法删除");
        }
        return Result.ok();
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        if (departmentService.removeById(id)) {
            return Result.ok().message("部门删除成功");
        }
        return Result.error().message("部门删除失败");
    }
}

