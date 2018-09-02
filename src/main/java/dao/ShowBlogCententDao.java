package dao;

import entity.BlogContent;
import entity.BlogContentQuery;
import entity.BlogInfoQuery;

import java.math.BigDecimal;
import java.util.List;

public interface ShowBlogCententDao {
    List<BlogContentQuery> ShowContent(BigDecimal pagenum, BigDecimal num);


}
