package com.normaling.websystemjava.Service.Impl;

import com.normaling.websystemjava.Mapper.DeptMapper;
import com.normaling.websystemjava.Mapper.EmpMapper;
import com.normaling.websystemjava.Model.Dept;
import com.normaling.websystemjava.Model.DeptLog;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Service.DeptLogService;
import com.normaling.websystemjava.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> getDeptsList() {
        return deptMapper.getDeptsList();
    }

    @Transactional
    @Override
    public void deleteDeptById(Integer id) {
        try {
            deptMapper.deleteDeptById(id);//根据id删除部门
            empMapper.deleteByDeptId(id);//根据部门id删除该部门下的员工

        } finally {
            DeptLog deptLog=new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
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
