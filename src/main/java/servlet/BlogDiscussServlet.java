package servlet;

import dao.BlogDiscussDao;
import entity.BlogDiscuss;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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

@WebServlet("/BlogDiscussServlet")
public class BlogDiscussServlet extends HttpServlet {

    public BlogDiscussDao blogDiscussDao;
//
//    public BlogDiscussDao getBlogDiscussDao() {
//        return blogDiscussDao;
//    }
//
//    public void setBlogDiscussDao(BlogDiscussDao blogDiscussDao) {
//        this.blogDiscussDao = blogDiscussDao;
//    }
//
    private BlogDiscuss blogDiscuss;
//
//    public BlogDiscuss getBlogDiscuss() {
//        return blogDiscuss;
//    }
//
//    public void setBlogDiscuss(BlogDiscuss blogDiscuss) {
//        this.blogDiscuss = blogDiscuss;
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.

        blogDiscuss.setUSER_ID(new BigDecimal(request.getParameter("userId")));
        blogDiscuss.setBLOG_ID(new BigDecimal(request.getParameter("blogId")));
        blogDiscuss.setDISCUSS_TEXT(request.getParameter("discussText"));


        int num = blogDiscussDao.insertDiscuss(blogDiscuss);
        boolean success = false;
        if (num == 1) {
            success = true;
        }

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

        PrintWriter out = response.getWriter();
        out.print(JSONObject.fromObject(success, jsonConfig));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
