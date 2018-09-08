package servlet;

import dao.ShowMyLikeNumDao;
import entity.MyBlogLikeNum;
import impl.ShowMyBlogLikeNumImpl;
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

@WebServlet( "/ShowMyBlogLikeNumServlet")
public class ShowMyBlogLikeNumServlet extends HttpServlet {
    //Home展示我的获得赞数量---DJN
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal userid = new BigDecimal(request.getParameter("nowuserid"));
        ShowMyLikeNumDao showMyLikeNumDao = new ShowMyBlogLikeNumImpl();
        List<MyBlogLikeNum> myBlogLikeNums = showMyLikeNumDao.ShowMyLikeNum(userid);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(myBlogLikeNums,jsonConfig);
        PrintWriter out =response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
