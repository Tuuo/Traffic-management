package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.User;
import com.isoft.service.UserService;
import com.isoft.utils.Result;
import com.isoft.vo.query.UserQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
//@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    @Resource
    private PasswordEncoder passwordEncoder;
    /**
     * 查询用户列表
     * @return
     */
    @GetMapping("/list")
    public Result list() {
        List<User> list = userService.list();
        return Result.ok(list);

    }
    @GetMapping("/getId")
    public Result getId(@RequestBody User user){
        User byUsername = userService.findByUsername(user.getUsername());
        return Result.ok(byUsername);

    }


}
