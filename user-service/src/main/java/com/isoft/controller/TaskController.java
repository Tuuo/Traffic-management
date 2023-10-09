package com.isoft.controller;

import com.isoft.entity.MyTask;
import com.isoft.entity.Task;
import com.isoft.service.TasksService;
import com.isoft.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TasksService tasksService;


    // 获取所有任务
    @GetMapping("/all")
    public Result selectTask(){
        List<Task> list = tasksService.list();
        return Result.ok(list) ;
    }
    @PutMapping("/update")
    public Result markMessageAsRead(@RequestBody Task task) {
        if (task != null) {
            if (!task.getReplied()) { // 检查通告是否已读
                // 将通告标记为已读
                task.setReplied(true); // 假设使用一个布尔字段表示已读状态
                tasksService.updateById(task);

                return Result.ok().message("通告已标记为已读。");
            } else {
                return Result.error().message("通告已经被标记为已读。");
            }
        } else {
            return Result.error().message("通知不存在");
        }
    }

}
