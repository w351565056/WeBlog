package impl;

import dao.BlogContentDao;
import entity.BlogContent;
import util.BaseDao;

public class BlogContentDaoImpl extends BaseDao<BlogContent> implements BlogContentDao {
    @Override
    public void InsertBlog(BlogContent blog) {
        executeUpdate("insert into blog_content(user_id,blog_text,blog_img) values(?,?,?)",
                new Object[]{blog.getUSER_ID(),blog.getBLOG_TEXT(),blog.getBLOG_IMG()});
    }
}
