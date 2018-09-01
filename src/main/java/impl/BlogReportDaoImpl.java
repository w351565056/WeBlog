package impl;

import dao.BlogReportDao;
import entity.BlogContent;
import util.BaseDao;

//举报
public class BlogReportDaoImpl extends BaseDao<BlogContent> implements BlogReportDao {


    @Override
    public int AddBlogReport(BlogContent blogContent) {
        return executeUpdate("Update BLOG_CONTENT set report = report + 1 where blog_id = ?",new Object[]{blogContent.getBLOG_ID()});
    }
}
