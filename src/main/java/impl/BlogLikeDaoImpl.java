package impl;

import dao.BlogLikeDao;
import entity.BlogLike;
import util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        Connection conn = null;
        ResultSet rs = null;
        String ret = "";
        int result = 0;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(true);
            PreparedStatement pre = conn.prepareStatement("select * from BLOG_LIKE where BLOG_ID = ? and USER_ID = ?");
            pre.setInt(1, blogLike.getBLOG_ID().intValue());
            pre.setInt(2, blogLike.getUSER_ID().intValue());
            rs = pre.executeQuery();
            if (rs.next()) {
                ret = rs.getString(1);
            }
            if (ret == "" || ret.equals(null)) {
                int LikeID = blogLike.getLIKE_ID().intValue();
                int BlogID = blogLike.getBLOG_ID().intValue();
                int UserID = blogLike.getUSER_ID().intValue();
                PreparedStatement pre1 =conn.prepareStatement("insert into BLOG_LIKE(LIKE_ID,BLOG_ID,USER_ID) values (?,?,?)");
                pre1.setInt(1,LikeID);
                pre1.setInt(2,BlogID);
                pre1.setInt(3,UserID);
                result = pre1.executeUpdate();
            } else {
                int BlogID = blogLike.getBLOG_ID().intValue();
                int UserID = blogLike.getUSER_ID().intValue();
                PreparedStatement pre1 =conn.prepareStatement("delete from BLOG_LIKE where BLOG_ID= ? and USER_ID = ?");
                pre1.setInt(1,BlogID);
                pre1.setInt(2,UserID);
                result = pre1.executeUpdate();
                result=0-result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    }

