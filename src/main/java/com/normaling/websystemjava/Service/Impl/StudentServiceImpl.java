package com.normaling.websystemjava.Service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.normaling.websystemjava.Mapper.StudentMapper;
import com.normaling.websystemjava.Model.PageBean;
import com.normaling.websystemjava.Model.Student;
import com.normaling.websystemjava.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<Student> list = studentMapper.list(name,gender,begin,end);
        Page<Student> p=(Page<Student>) list;
        //封装PageBean对象
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void deleteStudents(Integer[] ids) {
        studentMapper.deleteStudents(ids);
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }


}
