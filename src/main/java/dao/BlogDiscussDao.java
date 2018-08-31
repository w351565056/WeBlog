package dao;

import entity.BlogDiscuss;

import java.util.List;

public interface BlogDiscussDao {
    public List<BlogDiscuss> showDiscuss(BlogDiscuss blogDiscuss);
    public int insertDiscuss(BlogDiscuss blogDiscuss);
}
