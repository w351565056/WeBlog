package servlet;

import dao.ShowMyContentDao;
import dao.ShowMyInfoDao;
import dao.ShowMyRelDao;
import entity.*;
import impl.ShowMyContentImpl;
import impl.ShowMyInfoImpl;
import impl.ShowMyRelImpl;
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

@WebServlet("/HomeShowMyInfoServlet")
public class HomeShowMyInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BigDecimal myuserid = new BigDecimal("50");
            ShowMyContentDao showMyContent = new ShowMyContentImpl();
            ShowMyInfoDao showMyInfo = new ShowMyInfoImpl();
            ShowMyRelDao showMyRel= new ShowMyRelImpl();
            List<ShowMyContent> blogContents = showMyContent.ShowMyContent(myuserid);
            List<ShowMyInfo> showMyInfos = showMyInfo.ShowMyInfo(myuserid);
            List<ShowMyRel>  showMyRelsatten = showMyRel.ShowMyAttention(myuserid);
            List<ShowMyRel>  showMyRelsfuns = showMyRel.ShowMyFunnum(myuserid);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
            JSONArray array = JSONArray.fromObject(new Object[]{blogContents,showMyRelsatten,showMyRelsfuns,showMyInfos},jsonConfig);
//            JSONArray jsonArray = new JSONArray();
//            jsonArray.add(new Object[]{showMyInfos});
//             jsonArray.add(new Object[]{blogContents,showMyRelsatten,showMyRelsfuns,array });

            PrintWriter out = response.getWriter();
//        out.print(blogContents);
//        out.print(showMyInfos);
//        out.print(showMyRelsatten);
//        out.print(showMyRelsfuns);
//            out.print(jsonArray);
            out.print(array);
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
