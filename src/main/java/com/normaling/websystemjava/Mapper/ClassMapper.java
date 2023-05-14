package com.normaling.websystemjava.Mapper;

import com.normaling.websystemjava.Model.Classes;
import com.normaling.websystemjava.Model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    public List<Classes> getClassesList();

    void deleteClassById(Integer id);

    void addClass(Classes classes);

    Classes findById(Integer id);

    void updateClass(Classes classes);
}
