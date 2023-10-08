package com.isoft.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.entity.Department;
import com.isoft.entity.MyTask;
import org.apache.ibatis.annotations.Insert;

public interface HomePageMapper extends BaseMapper<MyTask> {
//    @Insert("insert into my_task(name) values #{name}")
//    MyTask saveByName(String name);
}
