package servlet;

import dao.BlogLikeDao;
import entity.BlogLike;
import impl.BlogLikeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/UserLikeBlogServlet")
public class UserLikeBlogServlet extends HttpServlet {
//    查看用户是否点过赞
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BlogLikeDao UserLikeBlog = new BlogLikeDaoImpl();
        BigDecimal blog_id=new BigDecimal( request.getParameter("blog_id"));
        BigDecimal user_id = new BigDecimal(request.getParameter("user_id"));
        BlogLike blogLike = new BlogLike();
        blogLike.setBLOG_ID(blog_id);
        blogLike.setUSER_ID(user_id);
        int ret =UserLikeBlog.UserLikeBlog(blogLike);
        PrintWriter out = response.getWriter();
        out.print(ret);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
