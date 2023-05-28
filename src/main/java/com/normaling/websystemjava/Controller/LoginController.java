package com.normaling.websystemjava.Controller;
import com.normaling.websystemjava.Model.Emp;
import com.normaling.websystemjava.Model.Result;
import com.normaling.websystemjava.Service.EmpService;
import com.normaling.websystemjava.Util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        if(e!=null){
            //登录成功，生成令牌，下发令牌
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt= JwtUtil.generateJwt(claims);
            return Result.success(jwt);
        }
        //登录失败，返回错误信息
        return Result.error("用户名或密码错误");
    }
}
