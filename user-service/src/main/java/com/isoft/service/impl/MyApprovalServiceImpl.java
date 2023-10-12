package com.isoft.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.dao.MyApprovalMapper;
import com.isoft.entity.Department;
import com.isoft.entity.MyApproval;
import com.isoft.service.MyApprovalService;
import com.isoft.utils.DepartmentTree;
import com.isoft.vo.query.MyApprovalQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class MyApprovalServiceImpl extends ServiceImpl<MyApprovalMapper, MyApproval> implements MyApprovalService {
    @Override
    public List<MyApproval> findApprovalList(MyApprovalQueryVo myApprovalQueryVo) {
        //创建条件构造器对象
        QueryWrapper<MyApproval> queryWrapper = new QueryWrapper<MyApproval>();
        //部门名称
        queryWrapper.like(!ObjectUtils.isEmpty(myApprovalQueryVo.getName()), "name",myApprovalQueryVo.getName());
        
        //查询部门列表
        List<MyApproval> myApprovalList = baseMapper.selectList(queryWrapper);

        return myApprovalList;
    }
}
