package dao;

import entity.UserInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface UserInfoDao {
    List<UserInfo> showAllUser();
    int insertUser(UserInfo user);//用户注册
    UserInfo LoginUser(UserInfo user);//用户登录
    List<UserInfo> findUserByName(UserInfo user);
    //解决用户账户名注册时的唯一性
    //删除用户
    List<UserInfo> deleteUser(BigDecimal userInfo);
    List<UserInfo> updataUser(BigDecimal USER_ID, String USER_NAME, String USER_PASS, String PHONE_NO, String TRUE_NAME, String GENDER, String EMAIL, String ADDRESS, String BLOOD_TYPE, Date BIRTHDAY, String QQ);
    List<UserInfo> addUser(String USER_NAME, String USER_PASS, String PHONE_NO, String TRUE_NAME, String GENDER, String EMAIL, String ADDRESS, String BLOOD_TYPE, Date BIRTHDAY, String QQ);

}
