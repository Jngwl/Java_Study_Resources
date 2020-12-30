package com.gaowl.dao;

import com.gaowl.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 根据Id查询用户
    User getUserByID(int id);

    // 分页
    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserByRowBounds();


}

