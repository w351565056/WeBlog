package dao;

import entity.ShowMyContent;

import java.math.BigDecimal;
import java.util.List;

public interface ShowMyContentDao {
    List<ShowMyContent> ShowMyContent(BigDecimal cnum);
}
