package servlet;

import dao.UserRelDao;
import entity.getCount;
import impl.UserRelDapImpl;
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

@WebServlet("/QueryAttentionServlet")
public class QueryAttentionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal fans_id = new BigDecimal(request.getParameter("USER_ID"));
        BigDecimal attenton_id = new BigDecimal(request.getParameter("userid"));
        UserRelDao dao=new UserRelDapImpl();
        List<getCount> list =dao.QueryAttention(fans_id,attenton_id);
        JSONArray array= JSONArray.fromObject(list);
        PrintWriter out=response.getWriter();
        out.print(array);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
