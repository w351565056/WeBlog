package impl;


import dao.ShowMyInfoDao;
import entity.ShowMyInfo;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class ShowMyInfoDaoImpl extends BaseDao<ShowMyInfo> implements ShowMyInfoDao {

    @Override
    public List<ShowMyInfo> ShowMyInfo(BigDecimal myuserid) {
        return executeQuery("select * from USER_INFO where USER_ID = ?",new Object[]{myuserid});
    }
}
