package dao;

import entity.BlogContentQuery;

import java.math.BigDecimal;
import java.util.List;

public interface SearchByLikeDao {
    //根据点赞评论转发数量分类排序---DJN
    List<BlogContentQuery> SearchByLike(BigDecimal pagenum, BigDecimal num);
    List<BlogContentQuery> SearchByforward(BigDecimal pagenum, BigDecimal num);
    List<BlogContentQuery> SearchByDiscuss(BigDecimal pagenum, BigDecimal num);
    List<BlogContentQuery> NavSearchBlog(String str, BigDecimal pagenum, BigDecimal num);
}
