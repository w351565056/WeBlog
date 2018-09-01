package servlet;

import dao.BlogReportDao;
import entity.BlogContent;
import entity.BlogDiscuss;
import impl.BlogReportDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/ReportServlet")

//举报
public class ReportServlet extends HttpServlet {

    BlogReportDao blogReportDao = new BlogReportDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("blogId");
        BigDecimal b_id = new BigDecimal(bid);

        BlogContent blogContent = new BlogContent();
        blogContent.setBLOG_ID(b_id);

        int ret = blogReportDao.AddBlogReport(blogContent);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
