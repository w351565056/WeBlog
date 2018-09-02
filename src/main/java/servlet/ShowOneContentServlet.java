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
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/ShowOneContentServlet")
public class ShowOneContentServlet extends HttpServlet {
    BlogContentDao dao = new BlogContentDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int blogid=Integer.parseInt(request.getParameter("blogid"));
        List<BlogContent> list = dao.ShowContentByBlogId(blogid);
        JsonConfig jsonConfig = new JsonConfig();//建立配置文件
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());//设置javaBean中的日期格式
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
