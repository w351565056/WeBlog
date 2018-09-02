package servlet;

import dao.ShowBlogCententDao;
import entity.BlogContent;
import entity.BlogContentQuery;
import impl.ShowBlogCententDaoImpl;
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

@WebServlet("/ShowContentByNumServlet")
public class ShowContentByNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal pagenum =new BigDecimal(request.getParameter("pagenum"));
        BigDecimal num = new BigDecimal("5");
        ShowBlogCententDao showBlogCentent = new ShowBlogCententDaoImpl();
        List<BlogContentQuery> list = showBlogCentent.ShowContent(pagenum,num);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSONArray array = JSONArray.fromObject(list,jsonConfig);
        response.getWriter().print(array);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
