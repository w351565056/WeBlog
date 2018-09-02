package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phonepass = request.getParameter("phonepass");//获取验证码
        String telvalet = (String) request.getSession().getAttribute("telvalite");//将session中存的验证码取出
        if(phonepass !=null && phonepass.equals(telvalet)){//判断验证码正确性
            response.getWriter().print(true);
        }else {
            response.getWriter().print(false);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
