package dao;

import entity.BlogContent;

import java.util.List;

public interface ShowContentDao {
     List<BlogContent> ShowContent(int i);  //查询指定个数的微博内容，i表示查询的个数
     List<BlogContent> ShowContent(String str,int i);//查询指定的微博内容或者指定话题的i个微博
     List<BlogContent> ShowContent();//查询热门话题
//     int addBlogContent（BlogContent BlogContent);//添加微博，返回影响条数，传入参数blog_content
}
