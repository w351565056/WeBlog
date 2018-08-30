package dao;

import entity.UserInfo;

import java.math.BigDecimal;
import java.util.List;

public interface UserInfoDao {
   List<UserInfo> showAllUser();
   //查询所有用户

  //删除用户
  List<UserInfo> deleteUser(BigDecimal userInfo);
}
