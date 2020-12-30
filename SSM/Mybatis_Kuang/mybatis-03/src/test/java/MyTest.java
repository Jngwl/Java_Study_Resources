import com.gaowl.dao.UserMapper;
import com.gaowl.pojo.User;
import com.gaowl.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class MyTest {

   static Logger logger = Logger.getLogger(MyTest.class);

    // 根据ID查询用户
    @Test
    public void getUserByID() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User users = mapper.getUserByID(1);
        logger.info("info：进入getUserByID方法成功");
        System.out.println(users);
        session.close();
    }

    @Test
    public void testLog4J(){
        logger.info("info：进入了testLog4J");
        logger.debug("debug：进入了testLog4J");
        logger.error("error：进入了testLog4J");
    }

    @Test
    public void getUserByLimit(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",2);
        map.put("pageSize",3);

        List<User> users = mapper.getUserByLimit(map);

        for (User user : users) {
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession session = MybatisUtils.getSession();

        // RowBounds
        RowBounds rowBounds = new RowBounds(1, 2);

        List<User> users = session.selectList("com.gaowl.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : users) {
            System.out.println(user);
        }

        session.close();
    }

}