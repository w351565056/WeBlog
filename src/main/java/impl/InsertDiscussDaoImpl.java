package impl;

import dao.InsertDiscussDao;
import entity.BlogDiscuss;
import util.BaseDao;
public class InsertDiscussDaoImpl extends BaseDao<BlogDiscuss> implements InsertDiscussDao {
    @Override
    public int insertDiscuss(BlogDiscuss blogDiscuss) {
        return executeUpdate("INSERT INTO BLOG_DISCUSS (BLOG_ID,USER_ID,DISCUSS_TEXT) VALUES (?,?,?)",new Object[]{
               blogDiscuss.getBLOG_ID(),blogDiscuss.getUSER_ID(),blogDiscuss.getDISCUSS_TEXT()
        });
    }
}
