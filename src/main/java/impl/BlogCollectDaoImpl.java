package impl;

import dao.BlogCollectDao;
import entity.BlogCollect;
import entity.BlogCollectQuery;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class BlogCollectDaoImpl extends BaseDao<BlogCollectQuery> implements BlogCollectDao {
    @Override
    public List<BlogCollectQuery> ShowCollectBlog(BlogCollectQuery blogCollect) {
        return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_COLLECT.* from USER_INFO,BLOG_COLLECT where BLOG_COLLECT.USER_ID = USER_INFO.USER_ID and BLOG_COLLECT.BLOG_ID= ?", new Object[]{blogCollect.getBLOG_ID()});
    }

    @Override
    public List<BlogCollect> collectblog(BigDecimal colid, BigDecimal colusergid, BigDecimal colblogid) {
         executeUpdate("insert into BLOG_COLLECT(COLLECT_ID,USER_ID,BLOG_ID) VALUES(?,?,?)",new Object[]{colid,colusergid,colblogid});
         return null;
    }
//    public List<BlogCollect> showcollect(BigDecimal userid){
//            return executeQuery("SELECT COUNT(*)AS NUMCOL,USER_ID AS USERID FROM\n" +
//                    "(SELECT * FROM BLOG_COLLECT where USER_ID =?) GROUP BY USER_ID",new Object[]{userid});
//    }
}
