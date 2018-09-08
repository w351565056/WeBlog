package impl;

import dao.ShowBlogCententDao;
import entity.BlogContentQuery;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class ShowBlogCententDaoImpl extends BaseDao<BlogContentQuery> implements ShowBlogCententDao {
    @Override
    public List<BlogContentQuery> ShowContent(BigDecimal pagenum, BigDecimal num) {
        return executeQuery("select * from(select * from (select rownum as A,USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_CONTENT.* from USER_INFO,BLOG_CONTENT where BLOG_CONTENT.USER_ID = USER_INFO.USER_ID order by BLOG_CONTENT.BLOG_ID desc) where  A < ?)where A>=?",new Object[]{pagenum.multiply(num),(pagenum.subtract(new BigDecimal(1))).multiply(num)});
    }

}
