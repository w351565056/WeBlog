package impl;

import dao.UserInfoDao;
import entity.UserInfo;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    @Override
    public List<UserInfo> showAllUser(){
        return executeQuery("select * from user_info order by USER_ID desc");
    }
    public List<UserInfo> findUserByName(UserInfo user){
        return executeQuery("select * from USER_INFO where USER_NAME=?",new Object[]{user.getUSER_NAME()});
    }

    //用户注册
    @Override
    public int insertUser(UserInfo user) {
        return executeUpdate("INSERT INTO USER_INFO(USER_NAME,USER_PASS,PHONE_NO) VALUES(?,?,?)",new Object[]{user.getUSER_NAME(),user.getUSER_PASS(),user.getPHONE_NO()});
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
  public List<UserInfo> deleteUser(BigDecimal userInfo) {
    return executeQuery("delete from user_info where USER_ID = ?",new Object[]{userInfo});
  }

  @Override
  public List<UserInfo> updataUser(BigDecimal USER_ID, String USER_NAME, String USER_PASS, String PHONE_NO, String TRUE_NAME, String GENDER, String EMAIL, String ADDRESS, String BLOOD_TYPE, Date BIRTHDAY, String QQ) {
    return executeQuery("UPDATE USER_INFO SET USER_NAME = ?,USER_PASS = ?,TRUE_NAME = ?,GENDER = ?,BLOOD_TYPE = ?,PHONE_NO = ?,EMAIL = ?,BIRTHDAY = ?,QQ = ?,ADDRESS = ? WHERE USER_ID = ?",new Object[]{
      USER_NAME,USER_PASS,TRUE_NAME,GENDER,BLOOD_TYPE,PHONE_NO,EMAIL,BIRTHDAY,QQ,ADDRESS,USER_ID
    });
  }

  @Override
  public List<UserInfo> addUser(String USER_NAME, String USER_PASS, String PHONE_NO, String TRUE_NAME, String GENDER, String EMAIL, String ADDRESS, String BLOOD_TYPE, Date BIRTHDAY, String QQ) {
    return executeQuery("insert into USER_INFO(USER_NAME,USER_PASS,PHONE_NO,TRUE_NAME,GENDER,EMAIL,ADDRESS,BLOOD_TYPE,BIRTHDAY,QQ) values(?,?,?,?,?,?,?,?,?,?)",new Object[]{USER_NAME,USER_PASS,PHONE_NO,TRUE_NAME,GENDER,EMAIL,ADDRESS,BLOOD_TYPE,BIRTHDAY,QQ});
  }

}
