package com.isoft.mapper;

import com.isoft.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
    @Select("select * from user where username = #{username} and password = #{password}")
    public User getName(@Param("username") String username,@Param("password") String password);
}
