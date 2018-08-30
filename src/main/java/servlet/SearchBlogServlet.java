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

@WebServlet("/SearchBlogServlet")
public class SearchBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                String keyword = "'微博'";
                BlogContentDao blogContentDao = new BlogContentDaoImpl();
                List<BlogContent> searchresult = blogContentDao.ShowContent(keyword);
                JSONArray json =JSONArray.fromObject(searchresult);
                PrintWriter out =response.getWriter();
                out.print(json);
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
