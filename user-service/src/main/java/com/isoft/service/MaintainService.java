package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Maintain;
import com.isoft.entity.MeetingAppointment;
import com.isoft.vo.query.MaintainQueryVo;
import com.isoft.vo.query.MeetingAppointmentQueryVo;

public interface MaintainService extends IService<Maintain> {
    IPage<Maintain> findRoleListByUserId(IPage<Maintain> page, MaintainQueryVo groupQueryVo);
}
