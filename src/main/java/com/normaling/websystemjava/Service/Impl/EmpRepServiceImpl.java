package com.normaling.websystemjava.Service.Impl;
import com.normaling.websystemjava.Mapper.EmpRepMapper;
import com.normaling.websystemjava.Model.GroupCount;
import com.normaling.websystemjava.Service.EmpRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Objects;

@Service
public class EmpRepServiceImpl implements EmpRepService {
    @Autowired
    EmpRepMapper empRepMapper;


    @Override
    public GroupCount getlist(String name, Integer gender, LocalDate begin, LocalDate end) {
        String[] count = empRepMapper.getCount(name, gender, begin, end);
        String[] jobType = empRepMapper.getJobType();
        changeJobType(jobType);
        GroupCount data=new GroupCount(jobType,count);
        return data;
    }

    private static void changeJobType(String[] jobType) {
        for (int i = 0; i < jobType.length; i++) {
            if(Objects.isNull(jobType[i])){
                jobType[i]="暂无职业";
            }else{
                if(jobType[i].equals("1")){
                    jobType[i]="班主任";
                }else if(jobType[i].equals("2")){
                    jobType[i]="讲师";
                }else if(jobType[i].equals("3")){
                    jobType[i]="学工主管";
                }else if(jobType[i].equals("4")){
                    jobType[i]="教研主管";
                }else if(jobType[i].equals("5")){
                    jobType[i]="咨询师";
                }
            }
        }
    }
}
