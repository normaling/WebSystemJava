package com.normaling.websystemjava.Service;
import com.normaling.websystemjava.Model.Emp;
import com.normaling.websystemjava.Model.PageBean;

import java.time.LocalDate;

public interface EmpService {


    /**
     * 分页查询员工信息
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void deleteEmps(Integer[] ids);

    /**
     * 新增员工
     * @param emp
     */
    void addEmp(Emp emp);

    /**
     * 通过id查找员工
     * @param id
     * @return
     */
    Emp findById(Integer id);

    /**
     * 修改员工
     * @param emp
     */
    void updateEmp(Emp emp);

    /**
     * 员工登录操作
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
