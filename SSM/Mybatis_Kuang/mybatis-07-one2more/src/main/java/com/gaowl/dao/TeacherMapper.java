package com.gaowl.dao;

import com.gaowl.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    // 获取所有老师
    List<Teacher> getAllTeachers();

    // 获取指定老师的信息，及其所管理的学生的信息
    Teacher getTeacher(@Param("id") int id);   // 此处参数为id，若写为tid会报错

    // 获取指定老师的信息，及其所管理的学生的信息
    Teacher getTeacher2(@Param("id") int id);   // 此处参数为id，和后面sql的传入参数对应，若写为tid后面也需要修改
}
