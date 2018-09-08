package servlet;

import dao.ShowMyRelDao;
import entity.ShowMyRel;
import impl.ShowMyRelDaoImpl;
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
import java.util.Date;
import java.util.List;

@WebServlet("/HomeShowMyAttenNumServlet")
public class HomeShowMyAttenNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Home 个人信息卡返回关注人数---DJN
            BigDecimal myuserid = new BigDecimal(request.getParameter("nowuserid"));
            ShowMyRelDao  showMyRelDao= new ShowMyRelDaoImpl();
            List<ShowMyRel> showMyRels = showMyRelDao.ShowMyAttention(myuserid);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(showMyRels,jsonConfig);
            PrintWriter out = response.getWriter();
            out.print(array);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
