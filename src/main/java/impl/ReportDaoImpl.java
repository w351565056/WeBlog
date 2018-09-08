package impl;

import dao.ReportDao;
import entity.Report;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ReportDaoImpl extends BaseDao<Report> implements ReportDao {
  //查询被举报的微博
  @Override
  public List<Report> showReport() {
    return executeQuery("select a.user_id,a.user_name,a.Lock_State,b.Blog_Id,b.Blog_Text,blog_img,b.Report from USER_INFO a,BLOG_CONTENT b where a.user_id = b.User_id and b.report > 0 order by b.report desc");
  }

  @Override
  public List<Report> CancelReport(BigDecimal BLOG_ID) {
    return executeQuery("UPDATE BLOG_CONTENT SET REPORT = 0 WHERE BLOG_ID = ?",new Object[]{BLOG_ID});
  }

  @Override
  public List<Report> deleteReportBlog(String BLOG_ID) {
    return executeQuery("delete from BLOG_CONTENT where BLOG_ID = ?",new Object[]{BLOG_ID});
  }

  @Override
  public List<Report> lockReportUser(String USER_ID) {
    return executeQuery("update user_info set LOCK_STATE = sysdate + 1 where USER_ID = ?",new Object[]{USER_ID});
  }


}
