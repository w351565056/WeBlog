package impl;

import dao.UserInfoDao;
import entity.UserInfo;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    @Override
    public List<UserInfo> showAllUser(){
        return executeQuery("select * from user_info");
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
    return executeQuery("delete * from user_info where user_id = ?",new Object[]{userInfo});
  }

}
