package com.normaling.websystemjava.Service.Impl;

import com.normaling.websystemjava.Mapper.DeptMapper;
import com.normaling.websystemjava.Model.Dept;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> getDeptsList() {
        return deptMapper.getDeptsList();
    }

    @Override
    public void deleteDeptById(Integer id) {
        deptMapper.deleteDeptById(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept findById(Integer id) {
        Dept data=deptMapper.findById(id);
        return data;
    }

    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }


}
