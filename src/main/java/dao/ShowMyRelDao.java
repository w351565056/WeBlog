package dao;

import entity.ShowMyRel;

import java.math.BigDecimal;
import java.util.List;

public interface ShowMyRelDao {
      //展示我的粉丝数，我关注的数量---DJN
      List<ShowMyRel>   ShowMyAttention(BigDecimal myattnum);
      List<ShowMyRel>   ShowMyFunnum(BigDecimal myfunnum);
}
