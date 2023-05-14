package com.normaling.websystemjava.Controller;
import com.normaling.websystemjava.Model.Emp;
import com.normaling.websystemjava.Model.PageBean;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

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
    @GetMapping
    public Result page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String name, Integer gender,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        PageBean data=empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(data);
    }

    /**
     * 批量删除员工
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public Result deleteEmps(@PathVariable Integer[] ids){
        empService.deleteEmps(ids);
        return Result.success();
    }

    /**
     * 新增员工
     * @param emp
     * @return
     */
    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        empService.addEmp(emp);
        return Result.success();
    }

    /**
     * 通过id查找员工
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id){
        Emp data=empService.findById(id);
        return Result.success(data);
    }

    /**
     * 修改员工
     * @param emp
     * @return
     */
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp){
        empService.updateEmp(emp);
        return Result.success();
    }


}
