package dao;

import entity.BlogLike;
import entity.MyBlogLikeNum;

import java.math.BigDecimal;
import java.util.List;

public interface ShowMyLikeNumDao {
    //展示我获得赞的数量---DJN
    List<MyBlogLikeNum> ShowMyLikeNum(BigDecimal likenum);
}
