package dao;

import entity.BlogCollect;

import java.math.BigDecimal;
import java.util.List;

public interface BlogCollectDao {
    void collectblog(BlogCollect blogCollect);
    List<BlogCollect> collectblog(BigDecimal colid, BigDecimal colusergid, BigDecimal colblogid);
    List<BlogCollect> showcollect(BigDecimal userid);
}
