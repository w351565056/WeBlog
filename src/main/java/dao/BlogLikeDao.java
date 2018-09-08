package dao;

import entity.BlogLike;

public interface BlogLikeDao {
    int addBlogLike(BlogLike blogLike);
    int showBlogLike(BlogLike blogLike);
    int UserLikeBlog(BlogLike blogLike);
}
