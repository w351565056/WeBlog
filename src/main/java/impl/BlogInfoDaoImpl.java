package impl;

import dao.BlogInfoDao;
import entity.BlogInfoQuery;
import util.BaseDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BlogInfoDaoImpl extends BaseDao<BlogInfoQuery> implements BlogInfoDao{
    @Override
    public List<BlogInfoQuery> ShowContentInfo(BigDecimal blog_id){
        Connection conn = null;
        ResultSet rs = null;
        int ret =0 ;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(true);
            PreparedStatement pre = conn.prepareStatement("select count(*) from BLOG_LIKE where BLOG_ID=?");
            pre.setInt(1,blog_id.intValue());
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
//        return ret;
        return null;
    }
}
