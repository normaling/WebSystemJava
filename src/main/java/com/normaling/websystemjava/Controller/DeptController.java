package com.normaling.websystemjava.Controller;
import com.normaling.websystemjava.Model.Dept;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Service.DeptService;
import com.normaling.websystemjava.anno.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    DeptService deptService;

    /**
     * 获取部门信息列表
     * @return
     */
    @GetMapping
    public Result getDepts(){
        List<Dept> data = deptService.getDeptsList();
        return Result.success(data);
    }

    /**
     * 根据id删除部门
     * @return
     */
    @Log
    @DeleteMapping("{id}")
    public Result deleteDeptById(@PathVariable Integer id){
        deptService.deleteDeptById(id);
        return Result.success();
    }

    /**
     * 增加部门
     * @param dept
     * @return
     */
    @Log
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 通过id查询部门
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id){
        Dept data=deptService.findById(id);
        return Result.success(data);
    }

    /**
     * 更新部门信息
     * @param dept
     * @return
     */
    @Log
    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        deptService.updateDept(dept);
        return Result.success();
    }

}
