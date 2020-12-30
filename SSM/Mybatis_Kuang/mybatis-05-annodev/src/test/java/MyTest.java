import com.gaowl.dao.UserMapper;
import com.gaowl.pojo.User;
import com.gaowl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void UserMapperTest(){
        SqlSession session = MybatisUtils.getSession();

        // 反射机制
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();   // 查询所有用户
        for (User user : users) {
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void UserMapperTest2(){
        SqlSession session = MybatisUtils.getSession();

        // 反射机制
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserByID(1);   // 通过id查询用户
        System.out.println(user);
        session.close();
    }


    @Test
    public void UserMapperTest3(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        mapper.addUser(new User(7, "anno_add", "root"));   // 增加用户
        session.close();
    }

    @Test
    public void UserMapperTest4(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        mapper.updateUser(new User(7, "anno_add", "root2333"));   // 修改用户信息
        session.close();
    }

    @Test
    public void UserMapperTest5(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        mapper.delete(5);   // 删除用户
        session.close();
    }



}
