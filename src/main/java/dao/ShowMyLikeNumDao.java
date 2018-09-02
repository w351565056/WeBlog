package dao;

import entity.BlogLike;
import entity.MyBlogLikeNum;

import java.math.BigDecimal;
import java.util.List;

public interface ShowMyLikeNumDao {
    List<MyBlogLikeNum> ShowMyLikeNum(BigDecimal likenum);
}
