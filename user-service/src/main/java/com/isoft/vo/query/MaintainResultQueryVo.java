package com.isoft.vo.query;

import com.isoft.entity.Maintain;
import com.isoft.entity.MaintainResult;
import lombok.Data;

@Data
public class MaintainResultQueryVo extends MaintainResult {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
