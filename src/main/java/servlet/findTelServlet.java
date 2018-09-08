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

@WebServlet("/findTelServlet")//电话号码唯一的
public class findTelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tel = request.getParameter("pnum");
        List<UserInfo> retList = new UserInfoDaoImpl().findtelUser(tel);
        if(retList.size()==0){
            response.getWriter().print(true);
        }else {
            response.getWriter().print(false);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
