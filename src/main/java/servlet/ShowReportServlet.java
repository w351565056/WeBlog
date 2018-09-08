package servlet;

import dao.ReportDao;
import entity.Report;
import impl.ReportDaoImpl;
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

@WebServlet("/ShowReportServlet")
public class ShowReportServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ReportDao dao = new ReportDaoImpl();
    //显示被举报的信息
    List<Report> reports = dao.showReport();
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
    JSONArray jsonArray = JSONArray.fromObject(reports,jsonConfig);
    PrintWriter out = response.getWriter();
    out.print(jsonArray);
//    System.out.println(jsonArray);
    out.close();
    out.flush();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
