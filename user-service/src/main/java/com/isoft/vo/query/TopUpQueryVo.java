package com.isoft.vo.query;

import com.isoft.entity.Maintain;
import com.isoft.entity.TopUp;
import lombok.Data;

@Data
public class TopUpQueryVo extends TopUp {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
