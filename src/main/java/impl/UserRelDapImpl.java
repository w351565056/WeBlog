package impl;

import dao.UserRelDao;
import entity.UserInfo;
import entity.UserRel;
import entity.getCount;
import util.BaseDao;

import java.util.List;

public class UserRelDapImpl extends BaseDao<getCount> implements UserRelDao {
    //粉丝数量
    public List<getCount> getCountFans(int i){
        return executeQuery("select attention_id,count(*) as count from User_rel where attention_id in(select fans_id from user_rel where attention_id=?)group by attention_id order by attention_id asc", new Object[]{i});
    }
    //关注数量
    public List<getCount> getCountAttention(int i){
        return executeQuery("select fans_id,count(*)as count from User_rel where fans_id in(select attention_id from user_rel where fans_id=?)group by fans_id order by fans_id asc", new Object[]{i});
    }
}
