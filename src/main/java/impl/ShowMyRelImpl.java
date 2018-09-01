package impl;

import dao.ShowMyRelDao;
import entity.ShowMyRel;
import util.BaseDao;

import java.math.BigDecimal;
import java.util.List;

public class ShowMyRelImpl extends BaseDao<ShowMyRel> implements ShowMyRelDao {

    @Override
    public List<ShowMyRel> ShowMyAttention(BigDecimal myattnum) {
        return executeQuery("select ATTENTION_ID,ROWNUM AS ANUM from USER_REL where FANS_ID = ?",new Object[]{myattnum});
    }

    @Override
    public List<ShowMyRel> ShowMyFunnum(BigDecimal myfunnum) {
        return executeQuery("select FANS_ID,ROWNUM AS FNUM from USER_REL where ATTENTION_ID = ?",new Object[]{myfunnum});
    }
}
