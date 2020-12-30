package com.gaowl.dao;

import com.gaowl.pojo.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserLike(String name);

    User getUserByID(int id);

    User getUserByNp(Map<String, Object> map);

    int addUser(User user);

    int addUser2(Map map);

    void updateUser(User user);

    void deleteUser(User user);


}

