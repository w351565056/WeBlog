package servlet;

import entity.BlogDiscuss;
import impl.InsertDiscussDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/InsertDiscussServlet")
public class InsertDiscussServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String did = request.getParameter("discussId");
        String bid = request.getParameter("blogId");
        String uid = request.getParameter("userId");
        String text = request.getParameter("discussText");

//        BigDecimal d_id = new BigDecimal(did);
        BigDecimal b_id = new BigDecimal(bid);
        BigDecimal u_id = new BigDecimal(uid);

        BlogDiscuss blogDiscuss = new BlogDiscuss();
//        blogDiscuss.setDISCUSS_ID(d_id);
        blogDiscuss.setBLOG_ID(b_id);
        blogDiscuss.setUSER_ID(u_id);
        blogDiscuss.setDISCUSS_TEXT(text);

        InsertDiscussDaoImpl bddi = new InsertDiscussDaoImpl();
        int ret = bddi.insertDiscuss(blogDiscuss);


        PrintWriter out = response.getWriter();

        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
