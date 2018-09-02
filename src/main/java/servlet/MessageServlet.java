package servlet;

import net.sf.json.JSONObject;
import util.GetMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");//获取电话号码
        String result = GetMessage.getResult(phone);//向用户发送验证码
        //response.getWriter().print(result);
        request.getSession().setAttribute("telvalite",result);//将返回的验证码存入session

        PrintWriter out =response.getWriter();//响应到前端
        out.print(result);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
