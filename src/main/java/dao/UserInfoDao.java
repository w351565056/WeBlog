package dao;
import entity.UserInfo;

import java.math.BigDecimal;
import java.util.List;

public interface UserInfoDao {
   //查询用户的所有信息
   List<UserInfo> showAllUser(int i);
   //更新个人信息
   int UpdateAllUser(UserInfo userInfo);
   //显示粉丝
   List<UserInfo> FansQuery(int i);
   //显示关注
   List<UserInfo> AttentionQuery(int i);
    List<UserInfo> showAllUser();
    int insertUser(UserInfo user);//用户注册
    UserInfo LoginUser(UserInfo user);//用户登录
    List<UserInfo> findUserByName(UserInfo user);
    //解决用户账户名注册时的唯一性
    //删除用户
    List<UserInfo> deleteUser(BigDecimal userInfo);


}
