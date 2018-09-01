package impl;

import dao.BlogContentDao;

import entity.BlogContent;
import util.BaseDao;



import java.math.BigDecimal;
import java.util.List;

public class BlogContentDaoImpl extends BaseDao<BlogContent> implements BlogContentDao {
    @Override
    public void InsertBlog(BlogContent blog) {
        executeUpdate("insert into blog_content(user_id,blog_text,blog_img) values(?,?,?)",
                new Object[]{blog.getUSER_ID(), blog.getBLOG_TEXT(), blog.getBLOG_IMG()});
    }

    @Override
    public List<BlogContent>
    ShowContent() {
       // return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_CONTENT.* from USER_INFO,BLOG_CONTENT where BLOG_CONTENT.USER_ID = USER_INFO.USER_ID");
        return executeQuery("select USER_INFO.USER_NAME,USER_INFO.HEAD_IMG,BLOG_CONTENT.* from USER_INFO,BLOG_CONTENT where BLOG_CONTENT.USER_ID = USER_INFO.USER_ID order by BLOG_CONTENT.BLOG_ID desc");
    }


    @Override
    public List<BlogContent> ShowContent(String str) {
        return executeQuery("select * from BLOG_CONTENT  where BLOG_TEXT like ?", new Object[]{str});
    }

    @Override
    public List<BlogContent> ShowContent(int i) {

        return null;

    }

    public List<BlogContent> ShowContenttopic(BigDecimal rowmax, BigDecimal rowmin) {
        return executeQuery("select * from (select *from (select rownum as ron,NUM1 AS NUMM,TOPIC2 AS TOP from（select count(*) as num1,topic2 from(select nvl(substr(BLOG_TEXT,instr(BLOG_TEXT,'#',1),instr(BLOG_TEXT,'#',1,2)),'null')as topic2 from BLOG_CONTENT)group by topic2 order by num1 desc）where TOPIC2 !='null') where ron <=?) where ron >?", new Object[]{rowmax, rowmin});

    }
}