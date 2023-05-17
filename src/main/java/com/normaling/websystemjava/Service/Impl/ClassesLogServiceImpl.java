package com.normaling.websystemjava.Service.Impl;
import com.normaling.websystemjava.Mapper.ClassesLogMapper;
import com.normaling.websystemjava.Model.ClassesLog;
import com.normaling.websystemjava.Model.DeptLog;
import com.normaling.websystemjava.Service.ClassesLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ClassesLogServiceImpl implements ClassesLogService {
    @Autowired
    ClassesLogMapper classesLogMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(ClassesLog classesLog) {
        classesLogMapper.insert(classesLog);
    }
}
