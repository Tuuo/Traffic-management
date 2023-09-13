package com.isoft.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public void getById(Integer id);
}
