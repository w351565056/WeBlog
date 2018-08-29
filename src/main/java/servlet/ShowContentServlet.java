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
import java.util.List;

@WebServlet("/ShowContentServlet")
public class ShowContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           //again
           request.setCharacterEncoding("UTF-8");
           response.setCharacterEncoding("UTF-8");
           BlogContentDao showContentDao = new BlogContentDaoImpl();
           String num= request.getParameter("num");
           int i =Integer.parseInt(num);
           List<BlogContent> list = showContentDao.ShowContent(i);
           JSONArray json =JSONArray.fromObject(list);
           response.getWriter().print(json);
       }catch (Exception e) {
           e.printStackTrace();
       }finally {

       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
