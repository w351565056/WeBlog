package servlet;

import dao.UserInfoDao;
import entity.UserInfo;
import impl.UserInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        UserInfoDao uid = new UserInfoDaoImpl();
        List<UserInfo> retList = uid.findUserByName(usfo);
        //判断数据库中账户名是否重复
        if (retList.size()==0){
            int ret =uid.insertUser(usfo);//没有重复，插入用户数据
            response.getWriter().print(true);
        }else {
            response.getWriter().print(false);
        }


//        PrintWriter out =response.getWriter();
//        out.print(ret);
//        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
