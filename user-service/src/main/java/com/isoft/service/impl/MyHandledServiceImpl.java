package com.isoft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.MyApprovalMapper;
import com.isoft.dao.MyHandledMapper;
import com.isoft.entity.MyApproval;
import com.isoft.entity.MyHandled;
import com.isoft.service.MyApprovalService;
import com.isoft.service.MyHandledService;
import org.springframework.stereotype.Service;

@Service
public class MyHandledServiceImpl extends ServiceImpl<MyHandledMapper, MyHandled> implements MyHandledService {
}
