package servlet;

import dao.BlogCollectDao;
import entity.BlogCollectQuery;
import impl.BlogCollectDaoImpl;
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

@WebServlet("/ShowCollectServlet")
public class ShowCollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal blogid = new BigDecimal(request.getParameter("blog_id"));
        BlogCollectDao showBlogCollect = new BlogCollectDaoImpl();
        BlogCollectQuery blogCollect = new BlogCollectQuery();
        blogCollect.setBLOG_ID(blogid);
        List<BlogCollectQuery> list = showBlogCollect.ShowCollectBlog(blogCollect);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray array = JSONArray.fromObject(list,jsonConfig);
        response.getWriter().print(array);
//        PrintWriter out = response.getWriter();
//        out.print(array);
//        out.flush();
//        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}