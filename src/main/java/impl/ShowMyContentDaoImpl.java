package impl;

import dao.ShowMyContentDao;

import entity.ShowMyContent;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;


public class ShowMyContentDaoImpl extends BaseDao<ShowMyContent> implements ShowMyContentDao {


    @Override
    public List<ShowMyContent> ShowMyContent(BigDecimal cnum) {
        return executeQuery("SELECT USER_ID,COUNT(*) AS CNUM FROM BLOG_CONTENT where USER_ID = ? GROUP BY USER_ID",new Object[]{cnum});
    }

    @Override
    public List<ShowMyContent> ShowMyContentpage(BigDecimal userid) {
        return null;
    }

    @Override
    public List<ShowMyContent> FindHotTopic(String str) {
        return executeQuery("select * from BLOG_CONTENT  where BLOG_TEXT like ?",new Object[]{str});
    }
}
