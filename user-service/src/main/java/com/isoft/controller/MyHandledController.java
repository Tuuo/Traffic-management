package com.isoft.controller;

import com.isoft.entity.MyHandled;
import com.isoft.service.MyHandledService;
import com.isoft.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/myHandled")
public class MyHandledController {
    @Resource
    private MyHandledService myHandledService;
    @PostMapping("/add")
    public Result addHandled(@RequestBody MyHandled myHandled){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 格式化日期时间为字符串
        String formattedDate = currentDateTime.format(formatter);
        myHandled.setDate(formattedDate);
        boolean save = myHandledService.save(myHandled);
        if(save){
            return Result.ok().message("已审批添加成功");
        }else {
            return Result.error().message("已审批添加失败");
        }
    }
    @GetMapping("/list")
    public Result listHandled(){
        List<MyHandled> myHandleds = myHandledService.list();
        return Result.ok(myHandleds);
    }
}
