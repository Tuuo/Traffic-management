package com.isoft.controller;

import com.isoft.service.UserService;
import com.isoft.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
//@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息（测试使用）
     * @param
     * @return
     */
    @GetMapping("/listAll")
    public Result listAll(){
        return Result.ok(userService.list());
    }



}
