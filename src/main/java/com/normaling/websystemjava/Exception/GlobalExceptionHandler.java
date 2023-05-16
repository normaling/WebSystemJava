package com.normaling.websystemjava.Exception;

import com.normaling.websystemjava.Model.Result;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕获名字重复SQL异常
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result SQLex(Exception ex){
        ex.printStackTrace();
        return Result.error("对不起，操作失败，名称重复。");
    }

    /**
     * jwt令牌失效异常
     * @param e
     * @return
     */
    @ExceptionHandler(ExpiredJwtException.class)
    public Result JWTex(ExpiredJwtException e){
        e.printStackTrace();
        return Result.error("登录失效，请重新登录");
    }

}
