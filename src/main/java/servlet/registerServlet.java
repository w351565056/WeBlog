package servlet;

import entity.UserInfo;
import impl.UserInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone_no = request.getParameter("phone_no");

        //封装数据
        UserInfo usfo = new UserInfo(username,password,phone_no);
        //dao操作
        int ret = new UserInfoDaoImpl().insertUser(usfo);
        if(ret!=0){
            response.getWriter().print(true);
            request.getSession().setAttribute("user",usfo);
        }else {
            response.getWriter().print(false);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
