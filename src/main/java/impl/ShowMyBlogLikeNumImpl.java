package impl;

import dao.ShowMyLikeNumDao;
import entity.BlogLike;
import entity.MyBlogLikeNum;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class ShowMyBlogLikeNumImpl extends BaseDao<MyBlogLikeNum> implements ShowMyLikeNumDao {
    @Override
    public List<MyBlogLikeNum> ShowMyLikeNum(BigDecimal likenum) {
        return executeQuery("SELECT COUNT(*) AS NUMLIK FROM BLOG_LIKE WHERE USER_ID = ?",new Object[]{likenum});
    }
}
