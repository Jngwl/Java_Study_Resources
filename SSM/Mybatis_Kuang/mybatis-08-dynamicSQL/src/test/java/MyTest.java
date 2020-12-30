import com.gaowl.dao.BlogMapper;
import com.gaowl.pojo.Blog;
import com.gaowl.utils.IDUtils;
import com.gaowl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void addBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class); // 此处传入的是接口，切记

        Blog blog = new Blog(IDUtils.getID(),"HelloJava","gaowl",new Date(),1000);
        int res = mapper.addBlog(blog);

        if(res>0){
            System.out.println("数据插入成功...");
        }

        blog = new Blog(IDUtils.getID(),"Mybatis冲冲冲","gaowl",new Date(),10000);
        res = mapper.addBlog(blog);

        if(res>0){
            System.out.println("数据插入成功...");
        }
        session.close();
    }


    @Test
    public void queryBlogIf(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class); // 此处传入的是接口，切记

        HashMap hashMap = new HashMap();
        // hashMap.put("title","HelloJava");
        hashMap.put("author","gaowl");

        List<Blog> blogs = mapper.queryBlogIf(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class); // 此处传入的是接口，切记

        HashMap hashMap = new HashMap();
        // hashMap.put("title","HelloJava");
        hashMap.put("author","gaowl");
        List<Blog> blogs = mapper.queryBlogIf(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void updateBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class); // 此处传入的是接口，切记

        HashMap hashMap = new HashMap();
        hashMap.put("title","Hello_Java");
        hashMap.put("author","gaowl");
        hashMap.put("id","6c3ed22ddc794e678be7240397831903");
        mapper.updateBlog(hashMap);

        session.close();
    }



    @Test
    public void queryBlogForeach(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class); // 此处传入的是接口，切记

        HashMap hashMap = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        hashMap.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        session.close();
    }



}
