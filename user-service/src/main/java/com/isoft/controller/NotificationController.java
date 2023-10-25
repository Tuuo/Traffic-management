package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.Group;
import com.isoft.entity.Notification;
import com.isoft.service.NotificationService;
import com.isoft.utils.Result;
import com.isoft.vo.query.GroupQueryVo;
import com.isoft.vo.query.NotificationQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/noti")
public class NotificationController {

    @Resource
    private NotificationService notificationService;

    @GetMapping("/list")
    public Result getList(NotificationQueryVo groupQueryVo){
        //创建分页对象
        IPage<Notification> page = new Page<Notification>(groupQueryVo.getPageNo(), groupQueryVo.getPageSize());
        //调用分页查询方法
        notificationService.findRoleListByUserId(page, groupQueryVo);
        //返回数据
        return Result.ok(page);
    }

    @PostMapping("/add")
    public Result addGroup(@RequestBody Notification group) {
        boolean save = notificationService.save(group);
        if (save){
            return Result.ok().message("添加成功");

        }
        return Result.error().message("添加失败");
    }
    @PutMapping("/update")
    public Result updateGroup(@RequestBody Notification group){
        boolean b = notificationService.updateById(group);
        if (b){
            return Result.ok();

        }
        return Result.error();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteGroup(@PathVariable Integer id){
        if (notificationService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
