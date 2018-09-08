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
import java.util.List;

@WebServlet("/UpdataUserServlet")
public class UpdataUserServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserInfoDao dao = new UserInfoDaoImpl();
    BigDecimal userid = new BigDecimal(request.getParameter("USER_ID"));
    String USER_NAME = request.getParameter("USER_NAME");
    String USER_PASS = request.getParameter("USER_PASS");
    String PHONE_NO = request.getParameter("PHONE_NO");
    String TRUE_NAME = request.getParameter("TRUE_NAME");
    String GENDER = request.getParameter("GENDER");
    String EMAIL = request.getParameter("EMAIL");
    String ADDRESS = request.getParameter("ADDRESS");
    String BLOOD_TYPE = request.getParameter("BLOOD_TYPE");
    //时间格式
    Date BIRTHDAY = null;
    try {
      BIRTHDAY = new SimpleDateFormat().parse(request.getParameter("BIRTHDAY"));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    String QQ = request.getParameter("QQ");
    List<UserInfo> list = dao.updataUser(userid,USER_NAME,USER_PASS,PHONE_NO,TRUE_NAME,GENDER,EMAIL,ADDRESS,BLOOD_TYPE,BIRTHDAY,QQ);
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
    JSONArray array = JSONArray.fromObject(list,jsonConfig);
    PrintWriter out =response.getWriter();
    out.print(array);
    out.flush();
    out.close();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
