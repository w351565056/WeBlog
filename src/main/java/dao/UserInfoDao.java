package dao;

import entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
   List<UserInfo> showAllUser(int i);
   int UpdateAllUser(UserInfo userInfo);
}
