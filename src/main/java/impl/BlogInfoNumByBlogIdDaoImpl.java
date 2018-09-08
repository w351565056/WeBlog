package impl;

import dao.BlogInfoNumByBlogIdDao;
import entity.BlogInfoNum;
import util.BaseDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogInfoNumByBlogIdDaoImpl extends BaseDao<BlogInfoNum>  implements BlogInfoNumByBlogIdDao {
    @Override
    public List<BlogInfoNum> showInfoNum(BigDecimal blog_id) {
        Connection conn = null;
        ResultSet rs = null;
        BlogInfoNum blogInfoNum = new BlogInfoNum();
        BigDecimal result = new BigDecimal(0);
        List<BlogInfoNum> list = new ArrayList<>();
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(true);
//            -------------------------------------------BLOG_COLLECT
            PreparedStatement pre = conn.prepareStatement("select count(*) from BLOG_COLLECT where BLOG_ID = ?");
            pre.setBigDecimal(1, blog_id);
            rs = pre.executeQuery();
            if (rs.next()) {
                result = rs.getBigDecimal(1);
            }
            blogInfoNum.setCollectNum(result);
//            -------------------------------------------BLOG_FORWARD
            PreparedStatement pre1 = conn.prepareStatement("select count(*) from BLOG_FORWARD where BLOG_ID = ?");
            pre1.setBigDecimal(1, blog_id);
            rs = pre1.executeQuery();
            if (rs.next()) {
                result = rs.getBigDecimal(1);
            }
            blogInfoNum.setForwardNum(result);
//            -------------------------------------------------BLOG_DISCUSS
            PreparedStatement pre2 = conn.prepareStatement("select count(*) from BLOG_DISCUSS where BLOG_ID = ?");
            pre2.setBigDecimal(1, blog_id);
            rs = pre2.executeQuery();
            if (rs.next()) {
                result = rs.getBigDecimal(1);
            }
            blogInfoNum.setDiscussNum(result);
//            --------------------------------------------------------
            PreparedStatement pre3 = conn.prepareStatement("select count(*) from BLOG_LIKE where BLOG_ID = ?");
            pre3.setBigDecimal(1, blog_id);
            rs = pre3.executeQuery();
            if (rs.next()) {
                result = rs.getBigDecimal(1);
            }
            blogInfoNum.setLikeNum(result);
//            --------------------------------------------------

            list.add(blogInfoNum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    }

