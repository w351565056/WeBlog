package dao;

import entity.BlogContent;

import java.math.BigDecimal;
import java.util.List;

public interface BlogContentDao {
    void InsertBlog(BlogContent blog);
    List<BlogContent> ShowContent();
    List<BlogContent> ShowContent(BigDecimal userid);  //查询指定个数的微博内容，i表示查询的个数
    List<BlogContent> ShowContent(String str);//查询指定的微博内容或者指定话题的i个微博
    List<BlogContent> ShowContenttopic(BigDecimal rowmax,BigDecimal rowmin);//查询热门话题
//     int addBlogContent（BlogContent BlogContent);//添加微博，返回影响条数，传入参数blog_content
    List<BlogContent> ShowContentByBlogId(int blogid);//根据微博id查询某条微博
}
