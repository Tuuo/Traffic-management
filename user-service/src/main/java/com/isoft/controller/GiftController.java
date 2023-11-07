package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.Gift;
import com.isoft.entity.Holiday;
import com.isoft.service.GiftService;
import com.isoft.service.HolidayService;
import com.isoft.utils.Result;
import com.isoft.vo.query.GiftQueryVo;
import com.isoft.vo.query.HolidayQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/gift")
public class GiftController {

    @Resource
    private GiftService maintainService;

    @GetMapping("/list")
    public Result getList(GiftQueryVo groupQueryVo){
        //创建分页对象
        IPage<Gift> page = new Page<Gift>(groupQueryVo.getPageNo(), groupQueryVo.getPageSize());
        //调用分页查询方法
        maintainService.findRoleListByUserId(page, groupQueryVo);
        //返回数据
        return Result.ok(page);
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteGroup(@PathVariable Integer id){
        if (maintainService.removeById(id)) {
            return Result.ok().message("领取成功");
        }
        return Result.error().message("领取失败");
    }
}
