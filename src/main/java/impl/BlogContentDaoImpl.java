package impl;

import dao.BlogContentDao;
import entity.BlogContent;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class BlogContentDaoImpl extends BaseDao<BlogContent> implements BlogContentDao {
    @Override
    public void InsertBlog(BlogContent blog) {
        executeUpdate("insert into blog_content(user_id,blog_text,blog_img) values(?,?,?)",
                new Object[]{blog.getUSER_ID(),blog.getBLOG_TEXT(),blog.getBLOG_IMG()});
    }
    @Override
    public List<BlogContent> ShowContent() {
        return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_CONTENT.* from USER_INFO,BLOG_CONTENT where BLOG_CONTENT.USER_ID = USER_INFO.USER_ID");
    }

    @Override
    public List<BlogContent> ShowContent(String str) {
        return executeQuery("select * from BLOG_CONTENT  where BLOG_TEXT like ?",new Object[]{str});
    }

    @Override
    public List<BlogContent> ShowContent(int i) {

        return null;
    }
}
