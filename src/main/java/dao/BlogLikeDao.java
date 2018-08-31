package dao;

import entity.BlogLike;

import java.math.BigDecimal;
import java.util.List;

public interface BlogLikeDao {
    int addBlogLike(BlogLike blogLike);
    int showBlogLike(BlogLike blogLike);
}
