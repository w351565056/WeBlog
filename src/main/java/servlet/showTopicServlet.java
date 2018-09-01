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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@WebServlet("/showTopicServlet")
public class showTopicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BigDecimal rowmin = null;
            BigDecimal rowmax = null;
            BigDecimal pnum = null;
            BigDecimal pagenum = new BigDecimal(request.getParameter("pagenum"));
            BigDecimal pagesize = new BigDecimal("3");
            pnum = new BigDecimal("1");
            rowmax = pagenum.multiply(pagesize);
            rowmin = pagenum.subtract(pnum).multiply(pagesize);
            BlogContentDao blogContentDao = new BlogContentDaoImpl();
            List<BlogContent>  blogtopics= blogContentDao.ShowContenttopic(rowmax,rowmin);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogtopics,jsonConfig);
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
