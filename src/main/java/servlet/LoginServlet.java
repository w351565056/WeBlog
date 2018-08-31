package servlet;

import entity.UserInfo;
import impl.UserInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")//用户登录
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得表单数据
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");
        //封装数据
        UserInfo usInf = new UserInfo(userName,userPass);
        //dao操作
        UserInfo retUser = new UserInfoDaoImpl().LoginUser(usInf);
        if(retUser!=null){
            request.getSession().setAttribute("user",retUser);
            response.getWriter().print(true);
        }else {
            response.getWriter().print(false);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
