package com.gaowl.dao;

import com.gaowl.pojo.Student;

import java.util.List;

public interface StudentMapper {

    // 查询所有的学生的信息，及其对应的老师的信息
    public List<Student> getStudents();

    public List<Student> getStudents2();
}
