package servlet;

import dao.ShowMyCollectNumDao;
import entity.BlogCollect;
import impl.ShowMyCollectNumDaoImpl;
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

@WebServlet("/ShowMyCollectNumServlet")
public class ShowMyCollectNumServlet extends HttpServlet {
    //Home展示我的收藏数量---DJN
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal userid = new BigDecimal(request.getParameter("nowuserid"));
        ShowMyCollectNumDao showMyCollectNumDao = new ShowMyCollectNumDaoImpl();
        List<BlogCollect> blogCollects = showMyCollectNumDao.showmyCollectnum(userid);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray array = JSONArray.fromObject(blogCollects,jsonConfig);
        PrintWriter out =response.getWriter();
        out.print(array);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
