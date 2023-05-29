package com.normaling.websystemjava.Controller;
import com.normaling.websystemjava.Model.Classes;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Service.ClassService;
import com.normaling.websystemjava.anno.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    ClassService classService;

    /**
     * 获取班级信息列表
     * @return
     */
    @GetMapping
    public Result getClasses(){
        List<Classes> data = classService.getClassesList();
        return Result.success(data);
    }
    /**
     * 根据id删除班级
     * @return
     */
    @Log
    @DeleteMapping("{id}")
    public Result deleteDeptById(@PathVariable Integer id){
        classService.deleteClassById(id);
        return Result.success();
    }
    /**
     * 增加班级
     * @param classes
     * @return
     */
    @Log
    @PostMapping
    public Result addClass(@RequestBody Classes classes){
        classService.addClass(classes);
        return Result.success();
    }
    /**
     * 通过id查询班级
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id){
        Classes data=classService.findById(id);
        return Result.success(data);
    }

    /**
     * 更新班级信息
     * @param classes
     * @return
     */
    @Log
    @PutMapping
    public Result updateClass(@RequestBody Classes classes){
        classService.updateClass(classes);
        return Result.success();
    }
}
