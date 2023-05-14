package com.normaling.websystemjava.Controller;

import com.normaling.websystemjava.Model.Emp;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    /**
     * 员工登录功能
     * @param emp
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        Emp e=empService.login(emp);
        return e != null?Result.success():Result.error("用户名或密码错误");
    }
}
