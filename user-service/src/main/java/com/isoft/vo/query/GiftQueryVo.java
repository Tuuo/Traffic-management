package com.isoft.vo.query;

import com.isoft.entity.Gift;
import com.isoft.entity.Holiday;
import lombok.Data;

@Data
public class GiftQueryVo extends Gift {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
