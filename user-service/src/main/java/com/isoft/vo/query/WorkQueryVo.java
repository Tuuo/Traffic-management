package com.isoft.vo.query;

import com.isoft.entity.EggSet;
import com.isoft.entity.Work;
import lombok.Data;

@Data
public class WorkQueryVo extends Work {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 2L;//每页显示数量
}
