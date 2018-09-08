package servlet;

import dao.ShowMyContentDao;
import entity.ShowMyContent;
import impl.ShowMyContentDaoImpl;
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

@WebServlet("/HomeShowMyInfoServlet")
public class HomeShowMyInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Home个人信息卡返回个人 微博数---DJN
            BigDecimal myuserid = new BigDecimal(request.getParameter("nowuserid"));
            ShowMyContentDao showMyContent = new ShowMyContentDaoImpl();

            List<ShowMyContent> blogContents = showMyContent.ShowMyContent(myuserid);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContents,jsonConfig);
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
