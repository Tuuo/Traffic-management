package com.isoft.controller;

import com.isoft.entity.MyApproval;
import com.isoft.service.MyApprovalService;
import com.isoft.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/myApproval")
public class MyApprovalController {

    @Resource
    private MyApprovalService myApprovalService;

    @PostMapping("/add")
    public Result addApproval(@RequestBody MyApproval myApproval) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 格式化日期时间为字符串
        String formattedDate = currentDateTime.format(formatter);
        myApproval.setDate(formattedDate);
        boolean save = myApprovalService.save(myApproval);
        if (save) {
            return Result.ok().message("办理审批成功");
        } else {
            return Result.error().message("办理审批失败");
        }

    }

    @GetMapping("/list")
    public Result listApproval() {
        List<MyApproval> myApprovals = myApprovalService.list();
        return Result.ok(myApprovals);
    }

}
