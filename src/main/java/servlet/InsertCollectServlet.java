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

@WebServlet("/InsertCollectServlet")
public class InsertCollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal userid = new BigDecimal(request.getParameter("user_id"));
        BigDecimal blogid = new BigDecimal(request.getParameter("blog_id"));
        BlogCollectDao blogCollect  = new BlogCollectDaoImpl();
        BlogCollectQuery blogCollectQuery = new BlogCollectQuery();
        blogCollectQuery.setBLOG_ID(blogid);
        blogCollectQuery.setUSER_ID(userid);
        int ret =blogCollect.collectblog(blogCollectQuery);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
