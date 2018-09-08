package servlet;

import entity.UserInfo;
import impl.UserInfoDaoImpl;
import util.GetMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String findtel = request.getParameter("key_num");
        List<UserInfo> list = new UserInfoDaoImpl().findtelUser(findtel);
        if(list.size()!=0){
            request.getSession().setAttribute("phoneNo",findtel);//存入用户电话号码
            String result = GetMessage.getResult(findtel);//向用户发送验证码
            request.getSession().setAttribute("telvalite",result);//将返回的验证码存入session
            response.getWriter().print(true);
            request.getSession().setAttribute("user",list.get(0));
        }else {
            response.getWriter().print(false);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
