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
    public int UpdateAllUser(UserInfo userInfo){
        return executeUpdate("update USER_INFO set user_name=?,true_name=?,phone_no=?,gender=?,email=?,address=?,blood_type=?,birthday=?,create_date_time=?,qq=?where user_id=3",
                new Object[]{userInfo.getUSER_NAME(),userInfo.getTRUE_NAME(),userInfo.getPHONE_NO(),userInfo.getGENDER(),userInfo.getEMAIL(),userInfo.getADDRESS(),userInfo.getBLOOD_TYPE(),userInfo.getBIRTHDAY(),userInfo.getCREATE_DATE_TIME(),userInfo.getQQ()});
    }
}
