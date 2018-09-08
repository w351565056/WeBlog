package servlet;

import entity.UserInfo;
import impl.UserInfoDaoImpl;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/LoginServlet")//用户登录
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得表单数据
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");
        //封装数据
        UserInfo usInf = new UserInfo(userName,userPass);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        //dao操作
        UserInfo retUser = new UserInfoDaoImpl().LoginUser(usInf);
        ///将retUser转为json
        JSONObject obj = JSONObject.fromObject(retUser,jsonConfig);
        if(retUser!=null){
            request.getSession().setAttribute("user",retUser);
        }

            response.getWriter().print(obj);///传上述json

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
