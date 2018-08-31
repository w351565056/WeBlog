package impl;

import dao.UserInfoDao;
import entity.UserInfo;
import util.BaseDao;

import java.util.List;

public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao {
    //查询个人信息
    @Override
    public List<UserInfo> showAllUser(int i){
        return executeQuery("select * from user_info where user_id=?",new Object[]{i});
    }
    //更新个人信息
    public int UpdateAllUser(UserInfo userInfo){
        return executeUpdate("update USER_INFO set user_name=?,true_name=?,phone_no=?,gender=?,email=?,address=?,blood_type=?,birthday=?,qq=?where user_id=100002",
                new Object[]{userInfo.getUSER_NAME(),userInfo.getTRUE_NAME(),userInfo.getPHONE_NO(),userInfo.getGENDER(),userInfo.getEMAIL(),userInfo.getADDRESS(),userInfo.getBLOOD_TYPE(),userInfo.getBIRTHDAY(),userInfo.getQQ()});
    }
    //显示粉丝

    @Override
    public List<UserInfo> FansQuery(int i) {
        return executeQuery("select * from user_info where user_id in (select fans_id from user_rel where attention_id=?)",new Object[]{i});
    }

    //显示关注

    @Override
    public List<UserInfo> AttentionQuery(int i) {
        return executeQuery("select * from user_info where user_id in (select attention_id from user_rel where fans_id=?)",new Object[]{i});
    }
}
