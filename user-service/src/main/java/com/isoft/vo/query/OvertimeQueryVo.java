package com.isoft.vo.query;

import com.isoft.entity.Holiday;
import com.isoft.entity.Overtime;
import lombok.Data;

@Data
public class OvertimeQueryVo extends Overtime {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
