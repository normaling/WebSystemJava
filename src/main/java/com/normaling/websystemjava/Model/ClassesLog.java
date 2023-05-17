package com.normaling.websystemjava.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesLog {
    Integer id;
    LocalDateTime CreateTime;
    String Description;
}
