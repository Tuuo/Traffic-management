package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.Meeting;
import com.isoft.entity.Notification;
import com.isoft.service.MeetingService;
import com.isoft.service.NotificationService;
import com.isoft.utils.Result;
import com.isoft.vo.query.MeetingQueryVo;
import com.isoft.vo.query.NotificationQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/meeting")
public class MeetingController {

    @Resource
    private MeetingService meetingService;

    @GetMapping("/list")
    public Result getList(MeetingQueryVo groupQueryVo){
        //创建分页对象
        IPage<Meeting> page = new Page<Meeting>(groupQueryVo.getPageNo(), groupQueryVo.getPageSize());
        //调用分页查询方法
        meetingService.findRoleListByUserId(page, groupQueryVo);
        //返回数据
        return Result.ok(page);
    }

    @PostMapping("/add")
    public Result addGroup(@RequestBody Meeting group) {
        boolean save = meetingService.save(group);
        if (save){
            return Result.ok().message("添加成功");

        }
        return Result.error().message("添加失败");
    }
    @PutMapping("/update")
    public Result updateGroup(@RequestBody Meeting group){
        boolean b = meetingService.updateById(group);
        if (b){
            return Result.ok();

        }
        return Result.error();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteGroup(@PathVariable Integer id){
        if (meetingService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
