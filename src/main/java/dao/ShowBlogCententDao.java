package dao;

import entity.BlogContent;
import entity.BlogContentQuery;

import java.math.BigDecimal;
import java.util.List;

public interface ShowBlogCententDao {
    List<BlogContentQuery> ShowContent(BigDecimal pagenum, BigDecimal num);  //查询指定个数的微博内容，i表示查询的个数
}
