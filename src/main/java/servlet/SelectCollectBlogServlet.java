package servlet;

import dao.BlogCollectDao;
import entity.BlogCollectQuery;
import impl.BlogCollectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/SelectCollectBlogServlet")
public class SelectCollectBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal blog_id=new BigDecimal( request.getParameter("blog_id"));
        BigDecimal user_id = new BigDecimal(request.getParameter("user_id"));
        BlogCollectQuery blogCollectQuery = new BlogCollectQuery();
        BlogCollectDao blogCollect = new BlogCollectDaoImpl();
        blogCollectQuery.setUSER_ID(user_id);
        blogCollectQuery.setBLOG_ID(blog_id);
        int ret = blogCollect.selectcollectblog(blogCollectQuery);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
