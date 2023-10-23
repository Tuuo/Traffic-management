package com.isoft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Basic_information;
import com.isoft.entity.Department;

/**
 * 个人信息
 */
public interface BasicService  extends IService<Basic_information> {
    Basic_information findBasicById(Integer id);

    boolean updateBasic(Basic_information basicInformation);
}
