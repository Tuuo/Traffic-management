package com.isoft;

import com.isoft.entity.Task;
import com.isoft.service.TasksService;
import com.isoft.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestTask {

    @Resource
    private TasksService tasksService;

    @Test
    void getTask(){

        Task task = tasksService.getById(1);
        System.out.println(task);

        if (task != null) {
            // 将通告标记为已读
            task.setReplied(true); // 假设使用一个布尔字段表示已读状态
            boolean b = tasksService.updateById(task);
            System.out.println(b);
            System.out.println("2"+task);
        } else {
            System.out.println("失败了");
            System.out.println(task);
        }

    }
}
