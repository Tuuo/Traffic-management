package com.isoft.controller;

import com.isoft.entity.Basic_information;
import com.isoft.service.BasicService;
import com.isoft.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/basic")
public class BasicController {
    @Resource
    private BasicService basicService;

    @GetMapping("/list")
    public Result getList(){
        List<Basic_information> list = basicService.list();
        return Result.ok(list);
    }

    @PostMapping("/add")
    public Result addBasic(@RequestBody Basic_information basicInformation) {
        boolean save = basicService.save(basicInformation);
        if (save){
            return Result.ok().message("添加成功");

        }
        return Result.error().message("添加失败");
    }
    @PutMapping("/update")
    public Result updateBasic(@RequestBody Basic_information basicInformation){
        boolean b = basicService.updateBasic(basicInformation);
        if (b){
            return Result.ok();

        }
        return Result.error();
    }
}
