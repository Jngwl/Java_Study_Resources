package com.gaowl.dao;

import com.gaowl.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from mybatis.user")
    List<User> getUsers();

    // 通过id查询用户
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id);

    // 方法存在多个参数时，在每个参数前面均添加上 @Param注解
    //User getUserByID(@Param("id") int id,@Param("name") String name);

    // 增加用户
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    // 修改用户信息
    @Update("update user set name=#{name},pwd=#{password} where id =#{id}")
    int updateUser(User user);

    // 删除用户
    @Delete("delete from user where id = #{uid}")
    int delete(@Param("uid") int id);

}

