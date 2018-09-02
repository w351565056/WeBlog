package dao;

import entity.BlogLike;

import java.math.BigDecimal;
import java.util.List;

public interface ShowMyLikeNumDao {
    List<BlogLike> ShowMyLikeNum(BigDecimal likenum);
}
