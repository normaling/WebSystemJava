package com.normaling.websystemjava.Mapper;

import com.normaling.websystemjava.Model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {

    public List<Dept> getDeptsList();

    public void deleteDeptById(Integer id);


    public void addDept(Dept dept);

    Dept findById(Integer id);

    void updateDept(Dept dept);
}
