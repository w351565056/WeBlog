package servlet;

import dao.BlogCollectDao;
import dao.BlogContentDao;
import entity.BlogCollect;
import impl.BlogCollectDaoImpl;
import impl.BlogContentDaoImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/collectBlogServlet")
public class collectBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BigDecimal colid = new BigDecimal("8");
            BigDecimal colusergid = new BigDecimal("18");
            BigDecimal colblogid = new BigDecimal("7");
            BlogCollectDao blogCollectDao = new BlogCollectDaoImpl();
            List<BlogCollect> blogCollects = blogCollectDao.collectblog(colid,colusergid,colblogid);
            PrintWriter out = response.getWriter();
            out.print(blogCollects);
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
