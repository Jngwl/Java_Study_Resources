import com.gaowl.dao.UserMapper;
import com.gaowl.pojo.User;
import com.gaowl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    // 查询全部用户
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        //方法一:
        //List<User> users = session.selectList("com.gaowl.mapper.UserMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getUserList();

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

    // 根据部分名字 迷糊查询用户
    @Test
    public void getUserLike(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> users = mapper.getUserLike("%李%");

        for (User user : users) {
            System.out.println(user);
        }

        session.close();
    }


    // 根据ID查询用户
    @Test
    public void getUserByID() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User users = mapper.getUserByID(1);

        System.out.println(users);

        session.close();
    }

    // 根据密码和名字查询用户
    @Test
    public void getUserByNP(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();

        map.put("userName", "com/gaowl");
        map.put("userPassword", "root");

        User user = mapper.getUserByNp(map);

        System.out.println(user);

        session.close();
    }

    @Test
    public void addUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(4, "com/gaowl","root");
        int i = mapper.addUser(user);
        if(i>0){
            System.out.println("数据插入成功...");
        }

        // 增删改均要提交事务
        session.commit();
        session.close();
    }

    @Test
    public void addUser2(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("userId",6);   // 仅插入id是可以的，这是其他两项默认为null
        map.put("userName","mybatis");


        mapper.addUser2(map);

        session.commit();
        session.close();
    }

    @Test
    public void updateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
//        User user = new User(4,"gaowl","newpwd");
        User user = mapper.getUserByID(4);
        user.setPwd("root");
        mapper.updateUser(user);

        // 增删改均要提交事务
        session.commit();
        session.close();
    }

    @Test
    public void deleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserByID(4);
        mapper.deleteUser(user);

        // 增删改均要提交事务
        session.commit();
        session.close();
    }
}