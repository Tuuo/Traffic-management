package com.isoft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.HomePageMapper;
import com.isoft.dao.TasksMapper;
import com.isoft.entity.MyTask;
import com.isoft.entity.Task;
import com.isoft.service.HomePageService;
import com.isoft.service.TasksService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TasksServiceImpl  extends ServiceImpl<TasksMapper, Task> implements TasksService {
}
