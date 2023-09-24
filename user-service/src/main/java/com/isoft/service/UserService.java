package com.isoft.service;

import com.isoft.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
public interface UserService extends IService<User> {


    User findByUsername(String username);
}
