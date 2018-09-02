package dao;

import entity.BlogInfoQuery;

import java.math.BigDecimal;
import java.util.List;

public interface BlogInfoDao {
    List<BlogInfoQuery> ShowContentInfo(BigDecimal blog_id);
}
