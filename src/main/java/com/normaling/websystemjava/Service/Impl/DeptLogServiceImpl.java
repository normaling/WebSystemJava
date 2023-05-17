package com.normaling.websystemjava.Service.Impl;

import com.normaling.websystemjava.Mapper.DeptLogMapper;
import com.normaling.websystemjava.Mapper.DeptMapper;
import com.normaling.websystemjava.Model.DeptLog;
import com.normaling.websystemjava.Service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    DeptLogMapper deptLogMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
