package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.Meeting;
import com.isoft.entity.MeetingAppointment;
import com.isoft.service.MeetingAppointmentService;
import com.isoft.service.MeetingService;
import com.isoft.utils.Result;
import com.isoft.vo.query.MeetingAppointmentQueryVo;
import com.isoft.vo.query.MeetingQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/appointment")
public class MeetingAppointmentController {

    @Resource
    private MeetingAppointmentService meetingAppointmentService;

    @GetMapping("/list")
    public Result getList(MeetingAppointmentQueryVo groupQueryVo){
        //创建分页对象
        IPage<MeetingAppointment> page = new Page<MeetingAppointment>(groupQueryVo.getPageNo(), groupQueryVo.getPageSize());
        //调用分页查询方法
        meetingAppointmentService.findRoleListByUserId(page, groupQueryVo);
        //返回数据
        return Result.ok(page);
    }

    @PostMapping("/add")
    public Result addGroup(@RequestBody MeetingAppointment group) {
        boolean save = meetingAppointmentService.save(group);
        if (save){
            return Result.ok().message("添加成功");

        }
        return Result.error().message("添加失败");
    }
    @PutMapping("/update")
    public Result updateGroup(@RequestBody MeetingAppointment group){
        boolean b = meetingAppointmentService.updateById(group);
        if (b){
            return Result.ok();

        }
        return Result.error();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteGroup(@PathVariable Integer id){
        if (meetingAppointmentService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
