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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //更新个人信息
         String USER_NAME=request.getParameter("USER_NAME");
         String PHONE_NO=request.getParameter("PHONE_NO");
         String TRUE_NAME=request.getParameter("TRUE_NAME");
         String GENDER=request.getParameter("GENDER");
         String EMAIL=request.getParameter("EMAIL");
         String ADDRESS=request.getParameter("ADDRESS");
         String BLOOD_TYPE=request.getParameter("BLOOD_TYPE");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date BIRTHDAY =null;
        try {
            BIRTHDAY=sdf.parse(request.getParameter("BIRTHDAY"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        Date CREATE_DATE_TIME=null;
//        try {
//            CREATE_DATE_TIME =sdf.parse(request.getParameter("CRESTE_DATE_TIME"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        String QQ=request.getParameter("QQ");
         UserInfo userBean=new UserInfo(USER_NAME,PHONE_NO,TRUE_NAME,GENDER,EMAIL,ADDRESS,BLOOD_TYPE,BIRTHDAY,QQ);
         UserInfoDao dao = new UserInfoDaoImpl();
         int re=dao.UpdateAllUser(userBean);
         PrintWriter out=response.getWriter();
         out.print(re);
         out.flush();
         out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
