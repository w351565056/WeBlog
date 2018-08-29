package impl;

import dao.BlogDiscussDao;
import entity.BlogDiscuss;
import util.BaseDao;

import java.util.List;

public class BlogDiscussDaoImpl extends BaseDao implements BlogDiscussDao {


    @Override
    public List<BlogDiscuss> showDiscuss(BlogDiscuss blogDiscuss) {
        return executeQuery("select * from BLOG_DISCUSS where BLOG_ID = ?",new Object[]{blogDiscuss.getBLOG_ID()});
    }



    @Override
    public int insertDiscuss(BlogDiscuss blogDiscuss) {
        return executeUpdate("INSERT INTO BLOG_DISCUSS(BLOG_ID,USER_ID,DISCUSS_TEXT,DISCUSS_IMG,CREATE_DATE_TIME,MODIFY_DATE_TIME,PREUSER_ID) VALUES (?,?,?,?,SYSDATE,SYSDATE,?)",new Object[]{
               blogDiscuss.getBLOG_ID(),blogDiscuss.getUSER_ID(),blogDiscuss.getDISCUSS_TEXT(),blogDiscuss.getDISCUSS_IMG(), blogDiscuss.getPREUSER_ID()
        });
    }
}
