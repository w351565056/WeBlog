package dao;

import entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
   List<UserInfo> showAllUser();
   //查询所有用户
}
