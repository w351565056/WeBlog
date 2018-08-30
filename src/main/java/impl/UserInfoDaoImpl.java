package impl;

import dao.UserInfoDao;
import entity.UserInfo;
import util.BaseDao;

import java.util.List;

public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    @Override
    public List<UserInfo> showAllUser(){
        return executeQuery("select * from user_info");
    }

  @Override
  public List<UserInfo> deleteUser(UserInfo userInfo) {
    return executeQuery("delete");
  }

}
