package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.isoft.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.vo.query.UserQueryVo;

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
    /**
     * 分页查询用户信息
     * @param page
     * @param userQueryVo
     * @return
     */
    IPage<User> findUserListByPage(IPage<User> page, UserQueryVo userQueryVo);

}
