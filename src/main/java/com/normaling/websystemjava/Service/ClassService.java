package com.normaling.websystemjava.Service;

import com.normaling.websystemjava.Model.Classes;
import com.normaling.websystemjava.Model.Dept;

import java.util.List;

public interface ClassService {
    /**
     * 获取班级信息表
     * @return
     */
    public List<Classes> getClassesList();

    /**
     * 根据id删除班级
     * @param id
     */
    void deleteClassById(Integer id);

    /**
     * 新增班级
     * @param classes
     */
    void addClass(Classes classes);

    /**
     * 根据id查询班级
     * @param id
     * @return
     */
    Classes findById(Integer id);

    /**
     * 更新班级信息
     * @param classes
     */
    void updateClass(Classes classes);
}
