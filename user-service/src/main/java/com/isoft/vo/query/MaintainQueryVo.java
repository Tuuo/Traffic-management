package com.isoft.vo.query;

import com.isoft.entity.Maintain;
import com.isoft.entity.MeetingAppointment;
import lombok.Data;

@Data
public class MaintainQueryVo extends Maintain {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
