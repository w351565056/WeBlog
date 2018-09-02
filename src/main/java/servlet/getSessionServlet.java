package servlet;

import entity.UserInfo;
import net.sf.json.JSONArray;
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

@WebServlet("/getSessionServlet")
public class getSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        JsonConfig jsonConfig = new JsonConfig();//建立配置文件
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());//设置javaBean中的日期格式
        JSONObject object = JSONObject.fromObject(user,jsonConfig);
        response.getWriter().print(object);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

