package com.normaling.websystemjava.Service;
import com.normaling.websystemjava.Model.PageBean;
import com.normaling.websystemjava.Model.Student;

import java.time.LocalDate;

public interface StudentService {
    /**
     * 分页查询学生信息
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除学生
     * @param ids
     */
    void deleteStudents(Integer[] ids);

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    Student findById(Integer id);

    /**
     * 修改学生信息
     * @param student
     */
    void updateStudent(Student student);
}
