package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.isoft.entity.User;
import com.isoft.dao.UserMapper;
import com.isoft.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.vo.query.UserQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiuqing
 * @since 2023-09-23
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findByUsername(String username) {

        //创建条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //用户名
        queryWrapper.eq("username",username);

        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 分页查询用户信息
     *
     * @param page
     * @param userQueryVo
     * @return
     */
    @Override
    public IPage<User> findUserListByPage(IPage<User> page, UserQueryVo userQueryVo)
    {

        //创建条件构造器对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//部门编号
        queryWrapper.eq(!ObjectUtils.isEmpty(userQueryVo.getDepartmentId()),
                "department_id",userQueryVo.getDepartmentId());
//用户名
        queryWrapper.like(!ObjectUtils.isEmpty(userQueryVo.getUsername()),
                "username",userQueryVo.getUsername());
//真实姓名
        queryWrapper.like(!ObjectUtils.isEmpty(userQueryVo.getRealName()),
                "real_name",userQueryVo.getRealName());
//电话
        queryWrapper.like(!ObjectUtils.isEmpty(userQueryVo.getPhone()),
                "phone",userQueryVo.getPhone());
//查询并返回数据
        return baseMapper.selectPage(page,queryWrapper);
    }

}
