package dao;

import entity.UserInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface UserInfoDao {
   //查询用户的所有信息
   List<UserInfo> showAllUser1();
    List<UserInfo> showAllUser(BigDecimal USER_ID);
    List<UserInfo> showUserByUserID(BigDecimal USER_ID);
   //更新个人信息
   int updataAllUser(UserInfo userInfo);
    List<UserInfo> FansQuery (BigDecimal USER_ID);
    //显示关注
    List<UserInfo> AttentionQuery (BigDecimal USER_ID);
    int insertUser(UserInfo user);//用户注册
    UserInfo LoginUser(UserInfo user);//用户登录
    List<UserInfo> findUserByName(UserInfo user);
    List<UserInfo> findtelUser(String str);
    //解决用户账户名注册时的唯一性
    int unlockUser(String username);
    //删除用户
    List<UserInfo> deleteUser(BigDecimal userInfo);
    List<UserInfo> updataUser(BigDecimal USER_ID, String USER_NAME, String USER_PASS, String
            PHONE_NO, String TRUE_NAME, String GENDER, String EMAIL, String ADDRESS, String BLOOD_TYPE, Date
                                      BIRTHDAY, String QQ);
    List<UserInfo> addUser(String HEAD_IMG, String USER_NAME, String USER_PASS, String PHONE_NO, String TRUE_NAME, String
            GENDER, String EMAIL, String ADDRESS, String BLOOD_TYPE, Date BIRTHDAY, String QQ);

}
