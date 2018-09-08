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

@WebServlet("/SearchByLikeServlet")
public class SearchByLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //热门微博根据评论、转发、获赞数量排序显示---DJN
        String getkeywordlike = request.getParameter("keywordlike");
        String getkeywordforward = request.getParameter("keywordforward");
        String getkeyworddiscuss = request.getParameter("keyworddiscuss");
        BigDecimal num = new BigDecimal("5");
        if ( getkeywordlike != null && getkeywordlike !=""){
            //根据获得赞数量排序查询
            BigDecimal keywordlike = new BigDecimal(getkeywordlike);
            SearchByLikeDao searchByLikeDao = new SearchByLikeDaoImpl();
            List<BlogContentQuery> blogContentslike= searchByLikeDao.SearchByLike(keywordlike,num);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContentslike,jsonConfig);
            PrintWriter out =response.getWriter();
            out.print(array);
            out.flush();
            out.close();
        }else if (getkeyworddiscuss != null && getkeyworddiscuss !=""){
            //根据获得评论数量排序查询
            BigDecimal keyworddiscuss = new BigDecimal(getkeyworddiscuss);
            SearchByLikeDao searchByLikeDao = new SearchByLikeDaoImpl();
            List<BlogContentQuery> blogContentsdiscuss= searchByLikeDao.SearchByDiscuss(keyworddiscuss,num);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContentsdiscuss,jsonConfig);
            PrintWriter out =response.getWriter();
            out.print(array);
            out.flush();
            out.close();
        }else if (getkeywordforward != null && getkeywordforward !=""){
            //根据获得转发数量排序查询
            BigDecimal keywordforward = new BigDecimal(getkeywordforward);
            SearchByLikeDao searchByLikeDao = new SearchByLikeDaoImpl();
            List<BlogContentQuery> blogContentforward= searchByLikeDao.SearchByforward(keywordforward,num);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(blogContentforward,jsonConfig);
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
