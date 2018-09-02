package dao;


import entity.BlogCollect;
import entity.BlogLike;


import java.math.BigDecimal;
import java.util.List;

public interface ShowMyCollectNumDao {
    List<BlogCollect> showmyCollectnum(BigDecimal collnum);

}
