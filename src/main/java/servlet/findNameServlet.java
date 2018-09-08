package servlet;

import entity.UserInfo;
import impl.UserInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findNameServlet")//用户名是唯一的
public class findNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("u_name");
        UserInfo user = new UserInfo(name);
        List<UserInfo> list = new UserInfoDaoImpl().findUserByName(user);
        if(list.size()==0){
            response.getWriter().print(true);
        }else {
            response.getWriter().print(false);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
