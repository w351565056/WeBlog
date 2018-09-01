package dao;

import entity.ShowMyRel;

import java.math.BigDecimal;
import java.util.List;

public interface ShowMyRelDao {
      List<ShowMyRel>   ShowMyAttention(BigDecimal myattnum);
      List<ShowMyRel>   ShowMyFunnum(BigDecimal myfunnum);
}
