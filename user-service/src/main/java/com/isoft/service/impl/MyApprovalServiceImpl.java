package com.isoft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.MyApprovalMapper;
import com.isoft.entity.MyApproval;
import com.isoft.service.MyApprovalService;
import org.springframework.stereotype.Service;

@Service
public class MyApprovalServiceImpl extends ServiceImpl<MyApprovalMapper, MyApproval> implements MyApprovalService {
}
