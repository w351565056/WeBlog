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
        return executeQuery("select * from BLOG_CONTENT");
    }

    @Override
    public List<BlogContent> ShowContent(String str, int i) {
        return null;
    }

    @Override
    public List<BlogContent> ShowContent(BigDecimal i) {
        return null;
    }
}
