package com.normaling.websystemjava.Service.Impl;

import com.normaling.websystemjava.Mapper.ClassMapper;
import com.normaling.websystemjava.Model.Classes;
import com.normaling.websystemjava.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;
    @Override
    public List<Classes> getClassesList() {
        return classMapper.getClassesList();
    }
    @Override
    public void deleteClassById(Integer id) {
        classMapper.deleteClassById(id);
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
