import com.gaowl.dao.StudentMapper;
import com.gaowl.dao.TeacherMapper;
import com.gaowl.pojo.Student;
import com.gaowl.pojo.Teacher;
import com.gaowl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    // 获取所有的老师
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getAllTeachers();

        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

        session.close();
    }


    // 获取指定老师的信息，及其所管理的学生的信息---联表查询
    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);
        session.close();
    }

    // 获取指定老师的信息，及其所管理的学生的信息---子查询
    @Test
    public void test3(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);

        System.out.println(teacher);
        session.close();
    }


}
