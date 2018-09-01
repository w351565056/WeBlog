package dao;

import entity.BlogCollect;
import entity.BlogCollectQuery;

import java.math.BigDecimal;
import java.util.List;

public interface BlogCollectDao {
    List<BlogCollectQuery> ShowCollectBlog(BlogCollectQuery blogCollect);


    List<BlogCollect> collectblog(BigDecimal colid, BigDecimal colusergid, BigDecimal colblogid);
}
