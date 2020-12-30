import com.gaowl.dao.UserMapper;
import com.gaowl.pojo.User;
import com.gaowl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    // 根据ID查询用户
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByID(2);
        System.out.println(user);

        User user2 = mapper.queryUserByID(2);
        System.out.println(user2);

        session.close();
    }

    // 根据ID查询用户
    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByID(2);
        System.out.println(user);
        session.close();


        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserByID(2);
        System.out.println(user2);
        session2.close();
    }



}
