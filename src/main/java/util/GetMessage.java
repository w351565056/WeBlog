package util;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * 获取短信验证码类
 * @author LB_lfx
 *
 *
 */
public class GetMessage {


    /**
     * 用户ID
     */
    public static final String ACCOUNT_SID = "fee1907b8006484e92f70e710f9ecad4";//这里填写你在平台里的ACOUNT_SID

    /**
     * 密钥
     */
    public static final String AUTH_TOKEN = "e9515051894d41bd9b6028e48e6f7426";

    /**
     * 请求地址前半部分
     */
    public static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//请求地址是固定的不用改

    public static  String randNum = RandUtil.getRandNum();

    //public  static String smsContent = "【蓝桥科技】尊敬的用户，您好，您的验证码为"+randNum+"，若非本人操作请忽略此短信。";
    
    public static String templateid = "437365285";//437365285 登录模板id  438033829 注册模板id
    
    public static String param = randNum;//模板中的变量值
    /**
     * (获取短信验证码)
     * @param to
     * @return String
     */
    public static String getResult(String to) {
    	//构造post请求
        String args = QueryUtil.queryArguments(ACCOUNT_SID, AUTH_TOKEN, templateid, param,to);
        OutputStreamWriter out = null;
        InputStream in = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();


        try {
            URL url = new URL(BASE_URL);
            URLConnection connection = url.openConnection(); //打开链接
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);  //设置链接超时
            connection.setReadTimeout(10000);    //设置读取超时

            //提交数据
            out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
            out.write(args);
            out.flush();

            //读取返回数据
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while((line = br.readLine())!=null){
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null) {
                    br.close();
                }
                if (out!=null) {
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jsonObject = JSONObject.fromObject(sb.toString());
        System.out.println(jsonObject);
        Object object = jsonObject.get("respCode");       
        if (!object.equals("00000")) {

            return "00000";
        }else{

            return randNum;
        }


    }
  //测试功能
//  public static void main(String[] args) {
//      String result = getResult("1780 ");
//      System.out.println("验证码："+result);
//  }
}
