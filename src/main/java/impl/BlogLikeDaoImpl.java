package impl;

import dao.BlogLikeDao;
import entity.BlogLike;
import util.BaseDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BlogLikeDaoImpl extends BaseDao<BlogLike> implements BlogLikeDao {
    @Override
    public int showBlogLike(BlogLike blogLike) {
        Connection conn = null;
        ResultSet rs = null;
        int ret=0;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(true);
            PreparedStatement pre = conn.prepareStatement("select count(*) from BLOG_LIKE where BLOG_ID=?");
            pre.setInt(1,blogLike.getBLOG_ID().intValue());
            rs = pre.executeQuery();
            if (rs.next()) {
                ret = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return ret;
    }
    @Override
    public int addBlogLike(BlogLike blogLike) {
        return executeUpdate("insert into BLOG_LIKE(LIKE_ID,BLOG_ID,USER_ID) values (?,?,?)", new Object[]{blogLike.getLIKE_ID(), blogLike.getBLOG_ID(), blogLike.getUSER_ID()});
    }
}
