package impl;

import dao.ShowMyCollectNumDao;
import entity.BlogCollect;
import util.BaseDao;

import java.math.BigDecimal;

import java.util.List;

public class ShowMyCollectNumDaoImpl extends BaseDao<BlogCollect> implements ShowMyCollectNumDao {


    @Override
    //Home展示我的收藏数---DJN
    public List<BlogCollect> showmyCollectnum(BigDecimal collnum) {
        return executeQuery("select COUNT(*)AS NUMCOL from BLOG_COLLECT WHERE USER_ID = ?",new Object[]{collnum});
    }
}
