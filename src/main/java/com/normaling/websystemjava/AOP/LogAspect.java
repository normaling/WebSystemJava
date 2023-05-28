package com.normaling.websystemjava.AOP;

import cn.hutool.json.JSONUtil;
import com.normaling.websystemjava.Mapper.OperateLogMapper;
import com.normaling.websystemjava.Model.OperateLog;
import com.normaling.websystemjava.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Autowired
    private HttpServletRequest request;//获取当前这次请求的请求对象

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.normaling.websystemjava.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作人的ID-当前登录员工的ID
        //获取请求头中的JWT令牌，解析令牌获取登录员工id
        String jwt = request.getHeader("token");
        Claims claims = JwtUtil.ParseJwt(jwt);
        Integer operateUser = (Integer) claims.get("id");
        //操作时间
        LocalDateTime operateTime=LocalDateTime.now();
        //操作类的类名
        String className = joinPoint.getTarget().getClass().getName();
        //操作的方法名
        String methodName = joinPoint.getSignature().getName();
        //操作方法传入的参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        //调用原始目标方法运行
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        //方法返回值
        String returnValue= JSONUtil.toJsonStr(result);
        long end = System.currentTimeMillis();
        //操作执行耗时
        Long costTime=end-begin;
        //记录操作日志
        OperateLog operateLog=new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP记录操作日志：{}",operateLog);
        return result;
    }
}
