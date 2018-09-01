package servlet;

import dao.BlogContentDao;
import entity.BlogContent;
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
import java.util.Date;
import java.util.List;

@WebServlet("/ShowContentServlet")
public class ShowContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           //again2
           request.setCharacterEncoding("UTF-8");
           response.setCharacterEncoding("UTF-8");
           BlogContentDao showContentDao = new BlogContentDaoImpl();
           List<BlogContent> list = showContentDao.ShowContent();
           JsonConfig jsonConfig = new JsonConfig();
           jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
           JSONArray array = JSONArray.fromObject(list,jsonConfig);
           response.getWriter().print(array);
       }catch (Exception e) {
           e.printStackTrace();
       }finally {
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
