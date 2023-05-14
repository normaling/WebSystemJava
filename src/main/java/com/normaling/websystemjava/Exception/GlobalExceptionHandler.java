package com.normaling.websystemjava.Exception;

import com.normaling.websystemjava.Model.Result;
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

}
