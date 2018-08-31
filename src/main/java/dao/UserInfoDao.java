package dao;

import entity.UserInfo;

import java.math.BigDecimal;
import java.util.List;

public interface UserInfoDao {
    List<UserInfo> showAllUser();
    int insertUser(UserInfo user);//用户注册
    UserInfo LoginUser(UserInfo user);//用户登录
    List<UserInfo> findUserByName(UserInfo user);
    //解决用户账户名注册时的唯一性
    //删除用户
    List<UserInfo> deleteUser(BigDecimal userInfo);


}
