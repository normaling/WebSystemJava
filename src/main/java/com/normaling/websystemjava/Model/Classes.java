package com.normaling.websystemjava.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
    private Integer id; //ID
    private String name; //班级名称
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
