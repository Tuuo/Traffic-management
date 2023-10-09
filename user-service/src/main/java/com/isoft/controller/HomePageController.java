package com.isoft.controller;

import com.isoft.entity.MyTask;
import com.isoft.service.HomePageService;
import com.isoft.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/homePage")
public class HomePageController {
    @Resource
    private HomePageService homePageService;

    @GetMapping("/list")
    public Result selectMyTask(){
        List<MyTask> list = homePageService.list();
        return Result.ok(list) ;
    }


    @PostMapping("/add")
    public Result myTask(@RequestBody MyTask myTask){
         if(homePageService.save(myTask)){
             return Result.ok().message("添加任务成功");
         }
            return Result.error().message("添加任务失败");

    }

}
