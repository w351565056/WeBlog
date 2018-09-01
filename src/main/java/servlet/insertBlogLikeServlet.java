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

@WebServlet("/insertBlogLikeServlet")
public class insertBlogLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BlogLikeDao insertBlogLike = new BlogLikeDaoImpl();
            BigDecimal like_id=new BigDecimal( request.getParameter("like_id"));
            BigDecimal blog_id=new BigDecimal( request.getParameter("blog_id"));
            BigDecimal user_id = new BigDecimal(25);
            BlogLike blogLike = new BlogLike();
            blogLike.setBLOG_ID(blog_id);
            blogLike.setUSER_ID(user_id);
            blogLike.setLIKE_ID(like_id);
            int ret =insertBlogLike.addBlogLike(blogLike);
            PrintWriter out = response.getWriter();
            out.print(ret);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
