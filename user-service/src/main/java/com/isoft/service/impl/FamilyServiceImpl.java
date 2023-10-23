package com.isoft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.BasicMapper;
import com.isoft.dao.FamilyMapper;
import com.isoft.entity.Basic_information;
import com.isoft.entity.Family;
import com.isoft.service.BasicService;
import com.isoft.service.FamilyService;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family> implements FamilyService {
}
