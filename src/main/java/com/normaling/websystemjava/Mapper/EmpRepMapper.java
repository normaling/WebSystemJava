package com.normaling.websystemjava.Mapper;
import com.normaling.websystemjava.Model.GroupCount;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface EmpRepMapper {
    /**
     * 获取工作的种类
     * @return
     */
    String[] getJobType();

    /**
     * 获取工作的人数
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    String[] getCount(String name, Integer gender, LocalDate begin, LocalDate end);
}
