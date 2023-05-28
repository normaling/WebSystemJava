package com.normaling.websystemjava.Controller;

import com.normaling.websystemjava.Model.Emp;
import com.normaling.websystemjava.Model.PageBean;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Model.Student;
import com.normaling.websystemjava.Service.EmpService;
import com.normaling.websystemjava.Service.StudentService;
import com.normaling.websystemjava.anno.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

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
    @GetMapping
    public Result page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String name, Integer gender,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        PageBean data=studentService.page(page,pageSize,name,gender,begin,end);
        return Result.success(data);
    }

    /**
     * 批量删除学生
     * @param ids
     * @return
     */
    @Log
    @DeleteMapping("{ids}")
    public Result deleteStudents(@PathVariable Integer[] ids){
        studentService.deleteStudents(ids);
        return Result.success();
    }

    /**
     * 通过id查找学生
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id){
        Student data=studentService.findById(id);
        return Result.success(data);
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Log
    @PutMapping
    public Result updateStudent(@RequestBody Student student){

        studentService.updateStudent(student);
        return Result.success();
    }
}
