package impl;

import dao.UserInfoDao;
import entity.UserInfo;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {

    //更新个人信息
    public int updataAllUser(UserInfo userInfo) {
        return executeUpdate("update USER_INFO set user_name=?,true_name=?,phone_no=?,gender=?,email=?,address=?,blood_type=?,birthday=?,qq=?,intro=? where user_id=?",
                new Object[]{userInfo.getUSER_NAME(), userInfo.getTRUE_NAME(), userInfo.getPHONE_NO(), userInfo.getGENDER(), userInfo.getEMAIL(), userInfo.getADDRESS(), userInfo.getBLOOD_TYPE(),userInfo.getBIRTHDAY(), userInfo.getQQ(),userInfo.getINTRO(),userInfo.getUSER_ID()});
    }

    @Override
    public List<UserInfo> showUserByUserID(BigDecimal USER_ID) {
        return executeQuery("select * from user_info where user_id=?", new Object[]{USER_ID});
    }

    @Override
    public List<UserInfo> showAllUser1() {
        return executeQuery("select * from user_info order by MODIFY_DATE_TIME desc");
    }

    //查找用户名
    public List<UserInfo> findUserByName(UserInfo user){
        return executeQuery("select * from USER_INFO where USER_NAME=?",new Object[]{user.getUSER_NAME()});
    }
    //显示粉丝
    //显示粉丝
    @Override
    public List<UserInfo> FansQuery (BigDecimal USER_ID){
        return executeQuery("select * from user_info where user_id in (select fans_id from user_rel where attention_id=?)order by user_id asc",new Object[]{USER_ID});
    }

    //显示关注
    @Override
    public List<UserInfo> AttentionQuery(BigDecimal USER_ID){
        return executeQuery("select * from user_info where user_id in (select attention_id from user_rel where fans_id=?)order by user_id asc", new Object[]{USER_ID});
    }

        //用户注册
        @Override
        public int insertUser (UserInfo user){
            return executeUpdate("INSERT INTO USER_INFO(USER_NAME,USER_PASS,PHONE_NO) VALUES(?,?,?)", new Object[]{user.getUSER_NAME(), user.getUSER_PASS(), user.getPHONE_NO()});
        }

    //用户登录
    @Override
    public UserInfo LoginUser(UserInfo user) {
        List<UserInfo> Uslist = new UserInfoDaoImpl().executeQuery("select * from USER_INFO WHERE USER_NAME =? AND USER_PASS=?",new Object[]{user.getUSER_NAME(),user.getUSER_PASS()});
            if(Uslist.size()>=1){
                return Uslist.get(0);
            }
            else {
                return null;
            }
    }
    @Override
    public int unlockUser(String username){
        return executeUpdate("UPDATE USER_INFO SET LOCK_STATE=''WHERE USER_NAME = ? ",new Object[]{username});
    }

  @Override
  public List<UserInfo> deleteUser(BigDecimal userInfo) {
    return executeQuery("delete from user_info where user_id = ?",new Object[]{userInfo});
  }
    @Override
    public List<UserInfo> addUser (String HEAD_IMG,String USER_NAME, String USER_PASS, String PHONE_NO, String TRUE_NAME, String
            GENDER, String EMAIL, String ADDRESS, String BLOOD_TYPE, Date BIRTHDAY, String QQ){
        return executeQuery("insert into USER_INFO(HEAD_IMG,USER_NAME,USER_PASS,PHONE_NO,TRUE_NAME,GENDER,EMAIL,ADDRESS,BLOOD_TYPE,BIRTHDAY,QQ) values(?,?,?,?,?,?,?,?,?,?,?)", new Object[]{HEAD_IMG,USER_NAME, USER_PASS, PHONE_NO, TRUE_NAME, GENDER, EMAIL, ADDRESS, BLOOD_TYPE, BIRTHDAY, QQ});
    }
    @Override
    public List<UserInfo> updataUser (BigDecimal USER_ID, String USER_NAME, String USER_PASS, String
            PHONE_NO, String TRUE_NAME, String GENDER, String EMAIL, String ADDRESS, String BLOOD_TYPE, Date
                                              BIRTHDAY, String QQ){
        return executeQuery("UPDATE USER_INFO SET USER_NAME = ?,USER_PASS = ?,TRUE_NAME = ?,GENDER = ?,BLOOD_TYPE = ?,PHONE_NO = ?,EMAIL = ?,BIRTHDAY = ?,QQ = ?,ADDRESS = ? WHERE USER_ID = ?", new Object[]{
                USER_NAME, USER_PASS, TRUE_NAME, GENDER, BLOOD_TYPE, PHONE_NO, EMAIL, BIRTHDAY, QQ, ADDRESS, USER_ID
        });
    }

    @Override
    public List<UserInfo> findtelUser(String str) {
        return executeQuery("select * from user_info where phone_no = ?",new Object[]{str});
    }

    @Override
    public List<UserInfo> showAllUser(BigDecimal USER_ID) {
        return executeQuery("select * from user_info order by USER_ID desc");
    }
}
