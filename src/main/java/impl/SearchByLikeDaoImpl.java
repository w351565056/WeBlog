package impl;

import dao.SearchByLikeDao;
import entity.BlogContentQuery;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class SearchByLikeDaoImpl extends BaseDao<BlogContentQuery> implements SearchByLikeDao {

    @Override
    public List<BlogContentQuery> SearchByLike(BigDecimal pagenum, BigDecimal num) {
        //根据微博评论、转发、获得赞 数量排序显示---DJN
        return executeQuery("SELECT * FROM(SELECT * FROM(select ROWNUM AS A,B.*,C.USER_NAME,C.HEAD_IMG from(SELECT COUNT(*) AS NUM1,D.BLOG_ID FROM\n" +
                "(SELECT A.*,C.USER_NAME,C.HEAD_IMG FROM BLOG_CONTENT A,BLOG_LIKE B,USER_INFO C \n" +
                "WHERE A.BLOG_ID = B.BLOG_ID ) D\n" +
                "group by D.BLOG_ID order by NUM1 desc)A,BLOG_CONTENT B,USER_INFO C WHERE A.BLOG_ID = B.BLOG_ID\n" +
                "AND B.USER_ID = C.USER_ID)E WHERE A<=?) WHERE A >=?",new Object[]{pagenum.multiply(num),(pagenum.subtract(new BigDecimal(1))).multiply(num)});
    }

    @Override
    public List<BlogContentQuery> SearchByforward(BigDecimal pagenum, BigDecimal num) {
        return executeQuery("SELECT * FROM(SELECT * FROM(select ROWNUM AS A,B.*,C.USER_NAME,C.HEAD_IMG from(SELECT COUNT(*) AS NUM1,D.BLOG_ID FROM\n" +
                "(SELECT A.*,C.USER_NAME,C.HEAD_IMG FROM BLOG_CONTENT A,BLOG_FORWARD B,USER_INFO C \n" +
                "WHERE A.BLOG_ID = B.BLOG_ID ) D\n" +
                "group by D.BLOG_ID order by NUM1 desc)A,BLOG_CONTENT B,USER_INFO C WHERE A.BLOG_ID = B.BLOG_ID\n" +
                "AND B.USER_ID = C.USER_ID)E WHERE A<=?) WHERE A >=?",new Object[]{pagenum.multiply(num),(pagenum.subtract(new BigDecimal(1))).multiply(num)});
    }

    @Override
    public List<BlogContentQuery> SearchByDiscuss(BigDecimal pagenum, BigDecimal num) {
        return executeQuery("SELECT * FROM(SELECT * FROM(select ROWNUM AS A,B.*,C.USER_NAME,C.HEAD_IMG from(SELECT COUNT(*) AS NUM1,D.BLOG_ID FROM\n" +
                "(SELECT A.*,C.USER_NAME,C.HEAD_IMG FROM BLOG_CONTENT A,BLOG_DISCUSS B,USER_INFO C \n" +
                "WHERE A.BLOG_ID = B.BLOG_ID ) D\n" +
                "group by D.BLOG_ID order by NUM1 desc)A,BLOG_CONTENT B,USER_INFO C WHERE A.BLOG_ID = B.BLOG_ID\n" +
                "AND B.USER_ID = C.USER_ID)E WHERE A<=?) WHERE A >=?",new Object[]{pagenum.multiply(num),(pagenum.subtract(new BigDecimal(1))).multiply(num)});
    }

    @Override
    public List<BlogContentQuery> NavSearchBlog(String str, BigDecimal pagenum, BigDecimal num) {
        return executeQuery("select* from(SELECT * FROM(SELECT ROWNUM AS A,C.*,B.USER_NAME,B.HEAD_IMG FROM (\n" +
                "                select * from BLOG_CONTENT  where BLOG_TEXT like ? ) C,USER_INFO B \n" +
                "                WHERE C.USER_ID = B.USER_ID order by BLOG_ID desc) WHERE A<=?）where A >=?",
                new Object[]{str,pagenum.multiply(num),(pagenum.subtract(new BigDecimal(1))).multiply(num)});
    }
}
