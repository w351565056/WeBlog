package servlet;

import dao.UserInfoDao;
import entity.UserInfo;
import impl.UserInfoDaoImpl;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/UpdateAllUserServlet")
public class UpdateAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoDao dao = new UserInfoDaoImpl();
        BigDecimal user_id = new BigDecimal(request.getParameter("USER_ID"));
        String USER_NAME = request.getParameter("USER_NAME");
        String PHONE_NO = request.getParameter("PHONE_NO");
        String TRUE_NAME = request.getParameter("TRUE_NAME");
        String GENDER = request.getParameter("GENDER");
        String EMAIL = request.getParameter("EMAIL");
        String ADDRESS = request.getParameter("ADDRESS");
        String BLOOD_TYPE = request.getParameter("BLOOD_TYPE");
        String QQ = request.getParameter("QQ");
        String INTRO=request.getParameter("INTRO");
        String birthday=request.getParameter("BIRTHDAY");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date BIRTHDAY=null;
        try {
            BIRTHDAY=sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserInfo userBean=new UserInfo(USER_NAME,PHONE_NO,TRUE_NAME,GENDER,EMAIL,ADDRESS,BLOOD_TYPE,BIRTHDAY,QQ,INTRO,user_id);
        int re = dao.updataAllUser(userBean);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray array = JSONArray.fromObject(re,jsonConfig);
        PrintWriter out =response.getWriter();
        out.print(array);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
