package dao;
import entity.UserInfo;

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
}
