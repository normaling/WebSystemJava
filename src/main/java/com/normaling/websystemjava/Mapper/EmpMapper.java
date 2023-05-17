package com.normaling.websystemjava.Mapper;

import com.normaling.websystemjava.Model.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询员工列表
     * @return
     */
    public List<Emp> list(String name, Integer gender, LocalDate begin,LocalDate end);

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

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getByAccount(Emp emp);

    /**
     * 根据部门ID删除该部门下的员工数据
     * @param deptId
     */
    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);
}
