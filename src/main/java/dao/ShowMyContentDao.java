package dao;

import entity.BlogContent;
import entity.ShowMyContent;

import java.math.BigDecimal;
import java.util.List;

public interface ShowMyContentDao {
    List<ShowMyContent> ShowMyContent(BigDecimal cnum);
    List<ShowMyContent> ShowMyContentpage(BigDecimal userid);
    List<ShowMyContent> FindHotTopic(String str);
}
