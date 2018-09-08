package impl;

import dao.HomeNavShowDao;
import entity.BlogContent;
import util.BaseDao;

import java.util.List;

public class HomeNavShowDaoImpl extends BaseDao<BlogContent> implements HomeNavShowDao {
    @Override
    public List<BlogContent> AllBlog() {
        //Home微博内容分类导航条---DJN
        return executeQuery("select T.BLOG_ID,\n" +
                "       T.USER_ID,\n" +
                "       T.BLOG_TEXT,\n" +
                "       T.BLOG_IMG,\n" +
                "       T.BLOG_FORWARD,\n" +
                "       T.REPORT,\n" +
                "       T.CREATE_DATE_TIME,\n" +
                "       T.MODIFY_DATE_TIME,\n" +
                "       A.USER_NAME,\n" +
                "       A.HEAD_IMG\n" +
                "        from(SELECT T.BLOG_ID,\n" +
                "              T.USER_ID,\n" +
                "           T.BLOG_TEXT,\n" +
                "             T.BLOG_IMG,\n" +
                "               T.BLOG_FORWARD,\n" +
                "                T.REPORT,\n" +
                "                 T.CREATE_DATE_TIME,\n" +
                "                   T.MODIFY_DATE_TIME FROM BLOG_CONTENT T,(select * from BLOG_CONTENT) A WHERE T.BLOG_ID = A.BLOG_ID) T,USER_INFO A WHERE T.USER_ID = A.USER_ID\n");
    }

    @Override
    public List<BlogContent> OriginalBlog() {
        return executeQuery("select T.BLOG_ID,\n" +
                "       T.USER_ID,\n" +
                "       T.BLOG_TEXT,\n" +
                "       T.BLOG_IMG,\n" +
                "       T.BLOG_FORWARD,\n" +
                "       T.REPORT,\n" +
                "       T.CREATE_DATE_TIME,\n" +
                "       T.MODIFY_DATE_TIME,\n" +
                "       A.USER_NAME,\n" +
                "       A.HEAD_IMG\n" +
                "        from(SELECT T.BLOG_ID,\n" +
                "              T.USER_ID,\n" +
                "           T.BLOG_TEXT,\n" +
                "             T.BLOG_IMG,\n" +
                "               T.BLOG_FORWARD,\n" +
                "                T.REPORT,\n" +
                "                 T.CREATE_DATE_TIME,\n" +
                "                   T.MODIFY_DATE_TIME FROM BLOG_CONTENT T,(select * from BLOG_CONTENT where not REGEXP_LIKE(BLOG_TEXT,'*.//@.*','i')) A WHERE T.BLOG_ID = A.BLOG_ID) T,USER_INFO A WHERE T.USER_ID = A.USER_ID\n");
    }

    @Override
    public List<BlogContent> PicBlog() {
        return executeQuery("select T.BLOG_ID,\n" +
                "       T.USER_ID,\n" +
                "       T.BLOG_TEXT,\n" +
                "       T.BLOG_IMG,\n" +
                "       T.BLOG_FORWARD,\n" +
                "       T.REPORT,\n" +
                "       T.CREATE_DATE_TIME,\n" +
                "       T.MODIFY_DATE_TIME,\n" +
                "       A.USER_NAME,\n" +
                "       A.HEAD_IMG\n" +
                "        from(SELECT T.BLOG_ID,\n" +
                "              T.USER_ID,\n" +
                "           T.BLOG_TEXT,\n" +
                "             T.BLOG_IMG,\n" +
                "               T.BLOG_FORWARD,\n" +
                "                T.REPORT,\n" +
                "                 T.CREATE_DATE_TIME,\n" +
                "                   T.MODIFY_DATE_TIME FROM BLOG_CONTENT T,(select * from BLOG_CONTENT where  REGEXP_LIKE(BLOG_IMG,'PNG|JPG','i')) A WHERE T.BLOG_ID = A.BLOG_ID) T,USER_INFO A WHERE T.USER_ID = A.USER_ID\n");
    }

    @Override
    public List<BlogContent> VideoBlog() {
        return executeQuery("select T.BLOG_ID,\n" +
                "       T.USER_ID,\n" +
                "       T.BLOG_TEXT,\n" +
                "       T.BLOG_IMG,\n" +
                "       T.BLOG_FORWARD,\n" +
                "       T.REPORT,\n" +
                "       T.CREATE_DATE_TIME,\n" +
                "       T.MODIFY_DATE_TIME,\n" +
                "       A.USER_NAME,\n" +
                "       A.HEAD_IMG\n" +
                "        from(SELECT T.BLOG_ID,\n" +
                "              T.USER_ID,\n" +
                "           T.BLOG_TEXT,\n" +
                "             T.BLOG_IMG,\n" +
                "               T.BLOG_FORWARD,\n" +
                "                T.REPORT,\n" +
                "                 T.CREATE_DATE_TIME,\n" +
                "                   T.MODIFY_DATE_TIME FROM BLOG_CONTENT T,(select * from BLOG_CONTENT where  REGEXP_LIKE(BLOG_IMG,'*.MP4.*','i')) A WHERE T.BLOG_ID = A.BLOG_ID) T,USER_INFO A WHERE T.USER_ID = A.USER_ID\n");
    }

    @Override
    public List<BlogContent> MusicBlog() {
        return executeQuery("select T.BLOG_ID,\n" +
                "       T.USER_ID,\n" +
                "       T.BLOG_TEXT,\n" +
                "       T.BLOG_IMG,\n" +
                "       T.BLOG_FORWARD,\n" +
                "       T.REPORT,\n" +
                "       T.CREATE_DATE_TIME,\n" +
                "       T.MODIFY_DATE_TIME,\n" +
                "       A.USER_NAME,\n" +
                "       A.HEAD_IMG\n" +
                "        from(SELECT T.BLOG_ID,\n" +
                "              T.USER_ID,\n" +
                "           T.BLOG_TEXT,\n" +
                "             T.BLOG_IMG,\n" +
                "               T.BLOG_FORWARD,\n" +
                "                T.REPORT,\n" +
                "                 T.CREATE_DATE_TIME,\n" +
                "                   T.MODIFY_DATE_TIME FROM BLOG_CONTENT T,(select * from BLOG_CONTENT where  REGEXP_LIKE(BLOG_IMG,'*.MP3.*','i')) A WHERE T.BLOG_ID = A.BLOG_ID) T,USER_INFO A WHERE T.USER_ID = A.USER_ID\n");
    }
}
