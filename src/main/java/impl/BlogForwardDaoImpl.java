package impl;

import dao.BlogForwardDao;
import entity.BlogForward;
import util.BaseDao;

public class BlogForwardDaoImpl extends BaseDao<BlogForward> implements BlogForwardDao {
    @Override
    public void insertForward(BlogForward bf) {
        executeUpdate("insert into BLOG_FORWARD(BLOG_ID,USER_ID) values(?,?)",new Object[]{bf.getBLOG_ID(),bf.getUSER_ID()});
    }
}
