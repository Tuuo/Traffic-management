package com.isoft.controller;

import com.isoft.entity.MyHandled;
import com.isoft.service.MyHandledService;
import com.isoft.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/myHandled")
public class MyHandledController {
    @Resource
    private MyHandledService myHandledService;
    @PostMapping("/add")
    public Result addHandled(@RequestBody MyHandled myHandled){
        boolean save = myHandledService.save(myHandled);
        if(save){
            return Result.ok();
        }else {
            return Result.error();
        }
    }
    @GetMapping("/list")
    public Result listHandled(){
        List<MyHandled> myHandleds = myHandledService.list();
        return Result.ok(myHandleds);
    }
}
