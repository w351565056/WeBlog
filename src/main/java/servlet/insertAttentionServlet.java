package servlet;

import dao.UserRelDao;
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

@WebServlet("/insertAttentionServlet")
public class insertAttentionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal fans_id = new BigDecimal(request.getParameter("USER_ID"));
        BigDecimal attenton_id = new BigDecimal(request.getParameter("userid"));
        UserRelDao dao=new UserRelDapImpl();
        int re=dao.insertAttention(fans_id,attenton_id);
        JSONArray array=JSONArray.fromObject(re);
        PrintWriter out=response.getWriter();
        out.print(array);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
