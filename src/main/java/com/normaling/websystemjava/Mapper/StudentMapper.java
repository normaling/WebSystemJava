package com.normaling.websystemjava.Mapper;
import com.normaling.websystemjava.Model.Student;
import org.apache.ibatis.annotations.Mapper;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> list(String name, Integer gender, LocalDate begin, LocalDate end);

    void deleteStudents(Integer[] ids);

    Student findById(Integer id);

    void updateStudent(Student student);
}
