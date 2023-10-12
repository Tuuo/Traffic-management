package com.isoft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.entity.MyApproval;
import com.isoft.entity.Task;
import com.isoft.vo.query.MyApprovalQueryVo;

import java.util.List;

public interface MyApprovalService extends IService<MyApproval> {
    List<MyApproval> findApprovalList(MyApprovalQueryVo myApprovalQueryVo);
}
