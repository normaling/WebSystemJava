package com.normaling.websystemjava.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface StudentRepMapper {
    /**
     * 获取学生人数
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    String[] getCount(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 获取学生工作类型
     * @return
     */
    String[] getJobType();
}
