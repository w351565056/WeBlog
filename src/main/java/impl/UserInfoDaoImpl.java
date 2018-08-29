package impl;

import dao.UserInfoDao;
import entity.UserInfo;
import util.BaseDao;

import java.util.List;

public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    @Override
    public List<UserInfo> showAllUser(int i){
        return executeQuery("select * from user_info where user_id=?",new Object[]{i});
    }
}
