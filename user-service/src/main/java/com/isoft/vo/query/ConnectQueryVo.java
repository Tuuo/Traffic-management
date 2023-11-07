package com.isoft.vo.query;

import com.isoft.entity.Connect;
import com.isoft.entity.Holiday;
import lombok.Data;

@Data
public class ConnectQueryVo extends Connect {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
