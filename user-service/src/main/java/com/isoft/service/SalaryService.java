package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Holiday;
import com.isoft.entity.Salary;
import com.isoft.vo.query.HolidayQueryVo;
import com.isoft.vo.query.SalaryQueryVo;

public interface SalaryService extends IService<Salary> {
    IPage<Salary> findRoleListByUserId(IPage<Salary> page, SalaryQueryVo groupQueryVo);
}
