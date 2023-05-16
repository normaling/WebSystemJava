package com.normaling.websystemjava.Service;

import com.normaling.websystemjava.Model.GroupCount;

import java.time.LocalDate;
public interface EmpRepService {
    /**
     * 封装数据
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */

    GroupCount getlist(String name, Integer gender, LocalDate begin, LocalDate end);
}
