package servlet;

import dao.BlogContentDao;
import entity.BlogContent;
import impl.BlogContentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/InsertBlogServlet")
public class InsertBlogServlet extends HttpServlet {
    BlogContentDao dao = new BlogContentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogcontent = request.getParameter("blogcontent");
        String imgpath = request.getParameter("imgpath");
        String forward = request.getParameter("forward");
        String userid = request.getParameter("userid");
        BlogContent blog = new BlogContent();
        blog.setBLOG_TEXT(blogcontent);
        blog.setBLOG_IMG(imgpath);
        blog.setBLOG_FORWARD(new BigDecimal(forward));//字符串能转成big吗?
        blog.setUSER_ID(new BigDecimal(userid));
        dao.InsertBlog(blog);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
