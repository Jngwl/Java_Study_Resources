import com.gaowl.dao.StudentMapper;
import com.gaowl.dao.TeacherMapper;
import com.gaowl.pojo.Student;
import com.gaowl.pojo.Teacher;
import com.gaowl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    // 测试环境搭建是否成功
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        session.close();
    }

    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();

        for (Student student : students) {
            System.out.println(student);
        }

        session.close();
    }

    @Test
    public void test3(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents2();

        for (Student student : students) {
            System.out.println(student);
        }

        session.close();
    }

}
