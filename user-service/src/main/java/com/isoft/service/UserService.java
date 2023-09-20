package com.isoft.service;

import com.isoft.entity.User;
import com.isoft.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Integer id) {
        return userMapper.findById(id);
    }
}
