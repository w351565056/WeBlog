package servlet;

import dao.SearchByLikeDao;
import entity.BlogContentQuery;
import impl.SearchByLikeDaoImpl;
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

@WebServlet("/SearchBlogServlet")
public class SearchBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    String keyword = null;
            try {
                //Home导航条模糊查询微博、超级话题---DJN
                BigDecimal pagenum = new BigDecimal(request.getParameter("pagenum"));
                BigDecimal num = new BigDecimal(5);
                String word = request.getParameter("keyword");
                if (word != null && !word.equals("")){
                    String lw = "%";
                    String rw = "%";
                    keyword = lw + word + rw ;
                }
                SearchByLikeDao dao = new SearchByLikeDaoImpl();
                List<BlogContentQuery> searchresult = dao.NavSearchBlog(keyword,pagenum,num);
                JsonConfig jsonConfig = new JsonConfig();
                jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
                JSONArray array = JSONArray.fromObject(searchresult,jsonConfig);
                PrintWriter out =response.getWriter();
                out.print(array);
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
