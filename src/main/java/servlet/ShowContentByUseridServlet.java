package servlet;

import dao.BlogCollectDao;
import dao.BlogContentDao;
import entity.BlogContent;
import impl.BlogCollectDaoImpl;
import impl.BlogContentDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@WebServlet("/ShowContentByUseridServlet")
public class ShowContentByUseridServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal userid = new BigDecimal(request.getParameter("user_id"));
        BlogContentDao blogContent = new BlogContentDaoImpl();
        List<BlogContent> list =blogContent.ShowContent(userid);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray array = JSONArray.fromObject(list,jsonConfig);
        response.getWriter().print(array);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
