package dao;


import entity.BlogCollect;
import entity.BlogLike;


import java.math.BigDecimal;
import java.util.List;

public interface ShowMyCollectNumDao {
    //展示我的收藏数量---DJN
    List<BlogCollect> showmyCollectnum(BigDecimal collnum);

}
