package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.Maintain;
import com.isoft.entity.TopUp;
import com.isoft.service.MaintainService;
import com.isoft.service.TopUpService;
import com.isoft.utils.Result;
import com.isoft.vo.query.MaintainQueryVo;
import com.isoft.vo.query.TopUpQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/topUp")
public class TopUpController {

    @Resource
    private TopUpService maintainService;

    @GetMapping("/list")
    public Result getList(TopUpQueryVo groupQueryVo){
        //创建分页对象
        IPage<TopUp> page = new Page<TopUp>(groupQueryVo.getPageNo(), groupQueryVo.getPageSize());
        //调用分页查询方法
        maintainService.findRoleListByUserId(page, groupQueryVo);
        //返回数据
        return Result.ok(page);
    }

}
