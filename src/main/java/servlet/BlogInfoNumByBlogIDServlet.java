package servlet;

import dao.BlogInfoNumByBlogIdDao;
import entity.BlogInfoNum;
import impl.BlogInfoNumByBlogIdDaoImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/BlogInfoNumByBlogIDServlet")
public class BlogInfoNumByBlogIDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal blog_id = new BigDecimal(request.getParameter("blog_id"));
        BlogInfoNumByBlogIdDao blogInfoNumByBlogId = new BlogInfoNumByBlogIdDaoImpl();
        List<BlogInfoNum> list = blogInfoNumByBlogId.showInfoNum(blog_id);
        JSONArray array = JSONArray.fromObject(list);
        PrintWriter out =response.getWriter();
        out.print(array);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
