package com.normaling.websystemjava.Mapper;

import com.normaling.websystemjava.Model.ClassesLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassesLogMapper {
    @Insert("insert into classes_log(create_time, description) values (#{CreateTime},#{Description})")
    void insert(ClassesLog classesLog);
}
