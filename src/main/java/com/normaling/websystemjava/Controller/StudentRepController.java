package com.normaling.websystemjava.Controller;

import com.normaling.websystemjava.Model.GroupCount;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Service.EmpRepService;
import com.normaling.websystemjava.Service.StudentRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/student_rep")
public class StudentRepController {
    @Autowired
    StudentRepService studentRepService;
    /**
     * 学生信息可视化
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    @GetMapping
    public Result getGroup(String name, Integer gender,
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        GroupCount data = studentRepService.getlist(name, gender, begin, end);
        return Result.success(data);
    }

}
