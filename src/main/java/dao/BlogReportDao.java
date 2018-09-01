package dao;

import entity.BlogContent;

public interface BlogReportDao {

    //举报
    public int AddBlogReport(BlogContent blogContent);
}
