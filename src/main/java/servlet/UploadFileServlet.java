package servlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.UploadFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by David on 2018/8/28.
 */
@WebServlet("/uploadFile")
public class UploadFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * 上传数据及保存文件
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        List<String> fileSrcList = UploadFile.upload(request);
        //ReadVideo.readVideoTime(request.getServletContext().getRealPath("/")+fileSrcList.get(0));//获得影片时长
        JSONObject obj = new JSONObject();
        obj.put("errno",0);
        obj.put("data", JSONArray.fromObject(fileSrcList));
        response.getWriter().print(obj.toString());
    }
}
