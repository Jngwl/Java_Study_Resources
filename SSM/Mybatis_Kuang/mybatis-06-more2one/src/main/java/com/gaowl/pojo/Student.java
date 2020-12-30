package com.gaowl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Student {
    private int id;
    private String name;

    // 学生要关联一个老师
    private Teacher teacher;

}
