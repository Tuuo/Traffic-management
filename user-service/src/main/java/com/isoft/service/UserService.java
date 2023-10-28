package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.isoft.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.vo.query.UserQueryVo;

import java.util.List;

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

    User findUserByUserName(String username);
    /**
     * 删除用户信息
     * @param id
     * @return
     */
    boolean deleteById(Long id);
    /**
     * 分配角色
     * @param userId
     * @param roleIds
     * @return
     */
    boolean saveUserRole(Long userId, List<Long> roleIds);
}
