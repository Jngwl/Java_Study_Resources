package com.gaowl.dao;

import com.gaowl.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    // 插入数据
    int addBlog(Blog blog);

    // 查询
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    // 更新博客
    int updateBlog(Map map);

    // 查询第1、2、3号博客
    List<Blog> queryBlogForeach(Map map);

}
