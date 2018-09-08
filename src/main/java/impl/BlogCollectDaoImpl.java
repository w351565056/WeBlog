package impl;

import dao.BlogCollectDao;
import entity.BlogCollectQuery;
import util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BlogCollectDaoImpl extends BaseDao<BlogCollectQuery> implements BlogCollectDao {
    @Override
    public List<BlogCollectQuery> ShowCollectBlog(BlogCollectQuery blogCollect) {
        return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_COLLECT.* from USER_INFO,BLOG_COLLECT where BLOG_COLLECT.USER_ID = USER_INFO.USER_ID and BLOG_COLLECT.BLOG_ID= ?", new Object[]{blogCollect.getBLOG_ID()});
    }

    @Override
    public int collectblog(BlogCollectQuery blogCollect) {
        return executeUpdate("insert into BLOG_COLLECT(USER_ID,BLOG_ID) VALUES(?,?)",new Object[]{blogCollect.getUSER_ID(),blogCollect.getBLOG_ID()});
    }

    @Override
    public int selectcollectblog(BlogCollectQuery blogCollect) {
        Connection conn = null;
        ResultSet rs = null;
        String ret = "";
        int result = 0;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(true);
            PreparedStatement pre = conn.prepareStatement("select * from BLOG_COLLECT where BLOG_ID = ? and USER_ID = ?");
            pre.setInt(1, blogCollect.getBLOG_ID().intValue());
            pre.setInt(2, blogCollect.getUSER_ID().intValue());
            rs = pre.executeQuery();
            if (rs.next()) {
                ret = rs.getString(1);
            }
            if (ret == "" || ret.equals(null)) {
                result = 0;
            } else {
                result = 1;
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
//    public List<BlogCollect> showcollect(BigDecimal userid){
//            return executeQuery("SELECT COUNT(*)AS NUMCOL,USER_ID AS USERID FROM\n" +
//                    "(SELECT * FROM BLOG_COLLECT where USER_ID =?) GROUP BY USER_ID",new Object[]{userid});
//    }
