package servlet;

import dao.UserInfoDao;
import dao.UserRelDao;
import entity.UserInfo;
import entity.UserRel;
import impl.UserInfoDaoImpl;
import impl.UserRelDapImpl;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/ShowFansServlet")
public class ShowFansServlet extends HttpServlet {
    UserInfoDao dao = new UserInfoDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //显示粉丝
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        String num= request.getParameter("num");
//        int i =Integer.parseInt(num);
        List<UserInfo> list = dao.FansQuery(50);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray array = JSONArray.fromObject(list,jsonConfig);
        PrintWriter out =response.getWriter();
        out.print(array);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
