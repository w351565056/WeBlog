package servlet;

import dao.BlogForwardDao;
import entity.BlogForward;
import impl.BlogForwardDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/InsertForwardServlet")
public class InsertForwardServlet extends HttpServlet {
        BlogForwardDao dao = new BlogForwardDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogid=request.getParameter("blogid");
        String userid=request.getParameter("userid");
        BlogForward bf =new BlogForward();
        bf.setBLOG_ID(new BigDecimal(blogid));
        bf.setUSER_ID(new BigDecimal(userid));
        dao.insertForward(bf);
//        response.getWriter().print("1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
