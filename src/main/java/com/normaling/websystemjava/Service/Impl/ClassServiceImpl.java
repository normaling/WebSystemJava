package com.normaling.websystemjava.Service.Impl;

import com.normaling.websystemjava.Mapper.ClassMapper;
import com.normaling.websystemjava.Mapper.StudentMapper;
import com.normaling.websystemjava.Model.Classes;
import com.normaling.websystemjava.Model.ClassesLog;
import com.normaling.websystemjava.Model.DeptLog;
import com.normaling.websystemjava.Service.ClassService;
import com.normaling.websystemjava.Service.ClassesLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClassesLogService classesLogService;

    @Override
    public List<Classes> getClassesList() {
        return classMapper.getClassesList();
    }
    @Transactional
    @Override
    public void deleteClassById(Integer id) {
        try {
            classMapper.deleteClassById(id);
            studentMapper.deleteByClassesId(id);
        } finally {
            ClassesLog classesLog=new ClassesLog();
            classesLog.setCreateTime(LocalDateTime.now());
            classesLog.setDescription("执行了解散班级的操作，此次解散是"+id+"号部门");
            classesLogService.insert(classesLog);
        }
    }

    @Override
    public void addClass(Classes classes) {
        classes.setCreateTime(LocalDateTime.now());
        classes.setUpdateTime(LocalDateTime.now());
        classMapper.addClass(classes);
    }

    @Override
    public Classes findById(Integer id) {
        Classes data=classMapper.findById(id);
        return data;
    }

    @Override
    public void updateClass(Classes classes) {
        classMapper.updateClass(classes);
    }
}
