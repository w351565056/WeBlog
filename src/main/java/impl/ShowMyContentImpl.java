package impl;

import dao.ShowMyContentDao;
import entity.ShowMyContent;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;


public class ShowMyContentImpl extends BaseDao<ShowMyContent> implements ShowMyContentDao {


    @Override
    public List<ShowMyContent> ShowMyContent(BigDecimal cnum) {
        return executeQuery("select USER_ID,ROWNUM AS CNUM from BLOG_CONTENT where USER_ID = ?",new Object[]{cnum});
    }
}
