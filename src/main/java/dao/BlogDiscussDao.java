package dao;

import entity.BlogDiscuss;

import java.util.List;

public interface BlogDiscussDao {
    List<BlogDiscuss> showDiscuss(BlogDiscuss blogDiscuss);


    int insertDiscuss(BlogDiscuss blogDiscuss);
}
