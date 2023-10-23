package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.Family;
import com.isoft.entity.Group;
import com.isoft.entity.Role;
import com.isoft.service.FamilyService;
import com.isoft.service.GroupService;
import com.isoft.utils.Result;
import com.isoft.vo.query.GroupQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    @Resource
    private GroupService groupService;

    @GetMapping("/list")
    public Result getList(GroupQueryVo groupQueryVo){
        //创建分页对象
        IPage<Group> page = new Page<Group>(groupQueryVo.getPageNo(), groupQueryVo.getPageSize());
        //调用分页查询方法
        groupService.findRoleListByUserId(page, groupQueryVo);
        //返回数据
        return Result.ok(page);
    }

    @PostMapping("/add")
    public Result addFamily(@RequestBody Group group) {
        boolean save = groupService.save(group);
        if (save){
            return Result.ok().message("添加成功");

        }
        return Result.error().message("添加失败");
    }
    @PutMapping("/update")
    public Result updateFamily(@RequestBody Group group){
        boolean b = groupService.updateById(group);
        if (b){
            return Result.ok();

        }
        return Result.error();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteFamily(@PathVariable Integer id){
        if (groupService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
