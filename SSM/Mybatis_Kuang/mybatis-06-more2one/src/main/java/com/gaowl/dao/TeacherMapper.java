package com.gaowl.dao;

import com.gaowl.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher where id = #{tid}")    // 此处比较简单，因此我们直接用注解了
    Teacher getTeacher(@Param("tid") int id);


}
