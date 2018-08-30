package impl;

import dao.BlogLikeDao;
import entity.BlogLike;
import util.BaseDao;

public class BlogLikeDaoImpl extends BaseDao<BlogLike> implements BlogLikeDao {
    @Override
    public void addBlogLike(BlogLike blogLike) {
        executeUpdate("insert into BLOG_LIKE(BLOG_ID,USER_ID) values (?,?)",new Object[]{blogLike.getBLOG_ID(),blogLike.getUSER_ID()});
    }
}
