package com.normaling.websystemjava.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id; //ID
    private String username; //用户名
    private String password; //密码
    private String name; //姓名
    private Short gender; //性别 , 1 男, 2 女
    private String image; //图像url
    private Short job; //职位 , 1,班长  , 2 副班长 , 3 团支书 , 4 学习委员 , 5 体育委员
    private LocalDate entrydate; //入学日期
    private Integer classId; //班级ID
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
