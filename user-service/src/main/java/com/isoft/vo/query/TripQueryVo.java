package com.isoft.vo.query;

import com.isoft.entity.Abroad;
import com.isoft.entity.Trip;
import lombok.Data;

@Data
public class TripQueryVo extends Trip {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
