package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.Holiday;
import com.isoft.entity.SummaryTime;
import com.isoft.service.HolidayService;
import com.isoft.service.SummaryTimeService;
import com.isoft.utils.Result;
import com.isoft.vo.query.HolidayQueryVo;
import com.isoft.vo.query.SummaryTimeQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/summaryTime")
public class SummaryTimeController {

    @Resource
    private SummaryTimeService maintainService;

    @GetMapping("/list")
    public Result getList(SummaryTimeQueryVo groupQueryVo){
        //创建分页对象
        IPage<SummaryTime> page = new Page<SummaryTime>(groupQueryVo.getPageNo(), groupQueryVo.getPageSize());
        //调用分页查询方法
        maintainService.findRoleListByUserId(page, groupQueryVo);
        //返回数据
        return Result.ok(page);
    }

    @PostMapping("/add")
    public Result addGroup(@RequestBody SummaryTime group) {
        boolean save = maintainService.save(group);
        if (save){
            return Result.ok().message("添加成功");

        }
        return Result.error().message("添加失败");
    }
    @PutMapping("/update")
    public Result updateGroup(@RequestBody SummaryTime group){
        boolean b = maintainService.updateById(group);
        if (b){
            return Result.ok();

        }
        return Result.error();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteGroup(@PathVariable Integer id){
        if (maintainService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
