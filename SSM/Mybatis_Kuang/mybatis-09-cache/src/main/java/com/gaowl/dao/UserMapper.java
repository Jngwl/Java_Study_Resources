package com.gaowl.dao;

import com.gaowl.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    // 根据ID查询用户
    User queryUserByID(@Param("id") int id);


}
