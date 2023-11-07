package com.isoft.vo.query;

import com.isoft.entity.Holiday;
import com.isoft.entity.Salary;
import lombok.Data;

@Data
public class SalaryQueryVo extends Salary {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
