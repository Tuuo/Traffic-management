package com.isoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.Meeting;
import com.isoft.entity.MeetingAppointment;
import com.isoft.vo.query.MeetingAppointmentQueryVo;
import com.isoft.vo.query.MeetingQueryVo;

public interface MeetingAppointmentService extends IService<MeetingAppointment> {
    IPage<MeetingAppointment> findRoleListByUserId(IPage<MeetingAppointment> page, MeetingAppointmentQueryVo groupQueryVo);
}
