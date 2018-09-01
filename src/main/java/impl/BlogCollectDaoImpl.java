package impl;

import dao.BlogCollectDao;
import entity.BlogCollect;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class BlogCollectDaoImpl extends BaseDao<BlogCollect> implements BlogCollectDao {
        public void collectblog(BlogCollect blogCollect){

        }

    @Override
    public List<BlogCollect> collectblog(BigDecimal colid, BigDecimal colusergid, BigDecimal colblogid) {
         executeUpdate("insert into BLOG_COLLECT(COLLECT_ID,USER_ID,BLOG_ID) VALUES(?,?,?)",new Object[]{colid,colusergid,colblogid});
         return null;
    }
    public List<BlogCollect> showcollect(BigDecimal userid){
            return executeQuery("SELECT COUNT(*)AS NUMCOL,USER_ID AS USERID FROM\n" +
                    "(SELECT * FROM BLOG_COLLECT where USER_ID =?) GROUP BY USER_ID",new Object[]{userid});
    }
}
