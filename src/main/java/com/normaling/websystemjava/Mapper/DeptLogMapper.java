package com.normaling.websystemjava.Mapper;

import com.normaling.websystemjava.Model.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into dept_log(create_time, description) values (#{CreateTime},#{Description})")
    void insert(DeptLog deptLog);
}
