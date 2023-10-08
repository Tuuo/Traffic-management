package com.isoft.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.HomePageMapper;
import com.isoft.dao.RoleMapper;
import com.isoft.entity.MyTask;
import com.isoft.entity.Role;
import com.isoft.service.HomePageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class HomePageServiceImpl extends ServiceImpl<HomePageMapper,MyTask> implements HomePageService{

}
