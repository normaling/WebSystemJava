package com.normaling.websystemjava.Service.Impl;

import com.normaling.websystemjava.Mapper.EmpRepMapper;
import com.normaling.websystemjava.Mapper.StudentRepMapper;
import com.normaling.websystemjava.Model.GroupCount;
import com.normaling.websystemjava.Service.StudentRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
@Service
public class StudentRepServiceImpl implements StudentRepService {
    @Autowired
    StudentRepMapper studentRepMapper;

    @Override
    public GroupCount getlist(String name, Integer gender, LocalDate begin, LocalDate end) {
        String[] count = studentRepMapper.getCount(name, gender, begin, end);
        String[] jobType = studentRepMapper.getJobType();
        changeJobType(jobType);
        GroupCount data=new GroupCount(jobType,count);
        return data;
    }
    private static void changeJobType(String[] jobType) {
        for (int i = 0; i < jobType.length; i++) {
            if(Objects.isNull(jobType[i])){
                jobType[i]="学生";
            }else{
                if(jobType[i].equals("1")){
                    jobType[i]="班长";
                }else if(jobType[i].equals("2")){
                    jobType[i]="副班长";
                }else if(jobType[i].equals("3")){
                    jobType[i]="学习委员";
                }else if(jobType[i].equals("4")){
                    jobType[i]="体育委员";
                }else if(jobType[i].equals("5")){
                    jobType[i]="心理委员";
                }
            }
        }
    }
}
