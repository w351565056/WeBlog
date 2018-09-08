package servlet;

import dao.ReportDao;
import entity.Report;
import impl.ReportDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonValueProcessor;

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

@WebServlet("/CancelReportServlet")
public class CancelReportServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ReportDao dao = new ReportDaoImpl();
    BigDecimal BLOG_ID = new BigDecimal(request.getParameter("BLOG_ID"));
    List<Report> reports = dao.CancelReport(BLOG_ID);
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class,new JsDateJsonValueProcessor());
    JSONArray jsonArray = JSONArray.fromObject(reports,jsonConfig);
    PrintWriter out = response.getWriter();
    out.print(jsonArray);
    out.flush();
    out.close();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
}
