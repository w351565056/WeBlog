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

@WebServlet("/ShowBlogLikeServlet")
public class ShowBlogLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BlogLikeDao showBlogLike = new BlogLikeDaoImpl();
            BigDecimal blog_id=new BigDecimal( request.getParameter("blog_id"));
            BlogLike blogLike = new BlogLike();
            blogLike.setBLOG_ID(blog_id);
            int num = showBlogLike.showBlogLike(blogLike);
            PrintWriter out =response.getWriter();
            out.print(num);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
