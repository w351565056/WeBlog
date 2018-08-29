package servlet;

import dao.BlogContentDao;
import entity.BlogContent;
import impl.BlogContentDaoImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
           JSONArray json =JSONArray.fromObject(list);
           PrintWriter out =response.getWriter();
           out.print(json);
           out.flush();
           out.close();
       }catch (Exception e) {
           e.printStackTrace();
       }finally {

       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
