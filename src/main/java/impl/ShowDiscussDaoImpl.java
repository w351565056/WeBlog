package impl;

import dao.ShowDiscussDao;
import entity.ShowDiscuss;
import util.BaseDao;

import java.util.List;
public class ShowDiscussDaoImpl extends BaseDao<ShowDiscuss> implements ShowDiscussDao {
    @Override
    public List<ShowDiscuss> showDiscuss(ShowDiscuss showDiscuss) {
        return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_DISCUSS.* from USER_INFO,BLOG_DISCUSS where BLOG_DISCUSS.USER_ID = USER_INFO.USER_ID and BLOG_DISCUSS.BLOG_ID = ? order by BLOG_DISCUSS.DISCUSS_ID desc",new Object[]{showDiscuss.getBLOG_ID()});
    }

}
