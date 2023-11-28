package com.isoft.vo.query;

import com.isoft.entity.Daily;
import com.isoft.entity.EggSet;
import lombok.Data;

@Data
public class DailyQueryVo extends Daily {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
