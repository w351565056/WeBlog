package impl;

import dao.BlogContentDao;

import entity.BlogContent;
import entity.ShowMyContent;
import util.BaseDao;



import java.math.BigDecimal;
import java.util.List;

public class BlogContentDaoImpl extends BaseDao<BlogContent> implements BlogContentDao {
    @Override
    public void InsertBlog(BlogContent blog) {
        executeUpdate("insert into blog_content(user_id,blog_text,blog_img,blog_forward) values(?,?,?,?)",
                new Object[]{blog.getUSER_ID(),blog.getBLOG_TEXT(),blog.getBLOG_IMG(),blog.getBLOG_FORWARD()});
    }

    @Override
    public List<BlogContent>
    ShowContent() {
       // return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_CONTENT.* from USER_INFO,BLOG_CONTENT where BLOG_CONTENT.USER_ID = USER_INFO.USER_ID");
        return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_CONTENT.* from USER_INFO,BLOG_CONTENT where BLOG_CONTENT.USER_ID = USER_INFO.USER_ID order by BLOG_CONTENT.BLOG_ID desc");
    }


    @Override
    public List<BlogContent> ShowContent(String str) {
        return executeQuery("select * from BLOG_CONTENT  where BLOG_TEXT like ?", new Object[]{str});
    }

    @Override
    public List<BlogContent> ShowContent(BigDecimal userid) {
        return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_CONTENT.* from USER_INFO,BLOG_CONTENT where BLOG_CONTENT.USER_ID = USER_INFO.USER_ID and USER_INFO.USER_ID = ? order by BLOG_CONTENT.BLOG_ID desc",new Object[]{userid});
    }

    @Override
    public List<BlogContent> ShowContenttopic(BigDecimal rowmax, BigDecimal rowmin) {
        return null;
    }

    @Override
    public List<BlogContent> ShowContentByBlogId(int blogid) {
//        return executeQuery("select * from BLOG_CONTENT  where BLOG_ID=?",new Object[]{blogid});
       return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_CONTENT.* from USER_INFO,BLOG_CONTENT where BLOG_CONTENT.BLOG_ID= ? AND BLOG_CONTENT.USER_ID = USER_INFO.USER_ID",new Object[]{blogid});
    }

}