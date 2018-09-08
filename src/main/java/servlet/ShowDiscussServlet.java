package servlet;

import dao.ShowDiscussDao;
import entity.ShowDiscuss;
import impl.ShowDiscussDaoImpl;
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

@WebServlet("/ShowDiscussServlet")
public class ShowDiscussServlet extends HttpServlet {

    ShowDiscussDao sdd = new ShowDiscussDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("blogId");
        BigDecimal b_id = new BigDecimal(bid);
        ShowDiscuss showDiscuss = new ShowDiscuss();
        showDiscuss.setBLOG_ID(b_id);

        List<ShowDiscuss> list = sdd.showDiscuss(showDiscuss);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());


        PrintWriter out = response.getWriter();
        out.print(JSONArray.fromObject(list,jsonConfig));
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
