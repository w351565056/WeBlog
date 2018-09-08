package dao;

import entity.BlogCollectQuery;

import java.util.List;

public interface BlogCollectDao {
    List<BlogCollectQuery> ShowCollectBlog(BlogCollectQuery blogCollect);
    int selectcollectblog(BlogCollectQuery blogCollect);
    int collectblog(BlogCollectQuery blogCollect);
}
