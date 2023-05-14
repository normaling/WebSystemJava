package com.normaling.websystemjava.Service;

import com.normaling.websystemjava.Model.Dept;
import com.normaling.websystemjava.Model.Result;

import java.time.LocalDateTime;
import java.util.List;

public interface DeptService {
    /**
     * 获取部门信息表
     * @return
     */
    public List<Dept> getDeptsList();

    /**
     * 根据id删除部门信息
     * @param id
     */
    void deleteDeptById(Integer id);

    /**
     * 增加部门
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 通过id查询部门
     * @param id
     * @return
     */
    Dept findById(Integer id);

    /**
     * 更加部门信息
     * @param dept
     */
    void updateDept(Dept dept);
}
