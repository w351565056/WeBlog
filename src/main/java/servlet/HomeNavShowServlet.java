package servlet;

import dao.HomeNavShowDao;
import entity.BlogContent;
import impl.HomeNavShowDaoImpl;
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

@WebServlet("/HomeNavShowServlet")
public class HomeNavShowServlet extends HttpServlet {
    //Home微博内容分类导航条---DJN
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String AllBlog = request.getParameter("AllBlog");
        String OriginalBlog = request.getParameter("OriginalBlog");
        String PicBlog = request.getParameter("PicBlog");
        String VideoBlog = request.getParameter("VideoBlog");
        String MusicBlog = request.getParameter("MusicBlog");
        if (AllBlog != null && AllBlog !=""){
            HomeNavShowDao homeNavShowDao = new HomeNavShowDaoImpl();
            List<BlogContent> blogContents = homeNavShowDao.AllBlog();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContents,jsonConfig);
            PrintWriter out =response.getWriter();
            out.print(array);
            out.flush();
            out.close();
        }else  if (OriginalBlog != null && OriginalBlog !=""){
            HomeNavShowDao homeNavShowDao = new HomeNavShowDaoImpl();
            List<BlogContent> blogContents = homeNavShowDao.OriginalBlog();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContents,jsonConfig);
            PrintWriter out =response.getWriter();
            out.print(array);
            out.flush();
            out.close();
        }else  if (PicBlog != null && PicBlog !=""){
            HomeNavShowDao homeNavShowDao = new HomeNavShowDaoImpl();
            List<BlogContent> blogContents = homeNavShowDao.PicBlog();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContents,jsonConfig);
            PrintWriter out =response.getWriter();
            out.print(array);
            out.flush();
            out.close();
        }else  if (VideoBlog != null && VideoBlog !=""){
            HomeNavShowDao homeNavShowDao = new HomeNavShowDaoImpl();
            List<BlogContent> blogContents = homeNavShowDao.VideoBlog();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContents,jsonConfig);
            PrintWriter out =response.getWriter();
            out.print(array);
            out.flush();
            out.close();
        }else  if (MusicBlog != null && MusicBlog !=""){
            HomeNavShowDao homeNavShowDao = new HomeNavShowDaoImpl();
            List<BlogContent> blogContents = homeNavShowDao.MusicBlog();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContents,jsonConfig);
            PrintWriter out =response.getWriter();
            out.print(array);
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
