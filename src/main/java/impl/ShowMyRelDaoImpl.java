package impl;

import dao.ShowMyRelDao;
import entity.ShowMyRel;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class ShowMyRelDaoImpl extends BaseDao<ShowMyRel> implements ShowMyRelDao {

    @Override
    public List<ShowMyRel> ShowMyAttention(BigDecimal myattnum) {
        return executeQuery("SELECT FANS_ID,nvl(COUNT(*),0) AS ANUM FROM  USER_REL where FANS_ID = ? GROUP BY FANS_ID",new Object[]{myattnum});
    }

    @Override
    public List<ShowMyRel> ShowMyFunnum(BigDecimal myfunnum) {
        return executeQuery("SELECT ATTENTION_ID,nvl(COUNT(*),0) AS FNUM FROM   USER_REL where ATTENTION_ID = ? GROUP BY ATTENTION_ID",new Object[]{myfunnum});
    }
}
