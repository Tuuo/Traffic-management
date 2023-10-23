package com.isoft.vo.query;

import com.isoft.entity.Group;
import com.isoft.entity.Role;
import lombok.Data;

@Data
public class GroupQueryVo extends Group {
    private Long pageNo = 1L;//当前页码
    private Long pageSize = 10L;//每页显示数量
}
