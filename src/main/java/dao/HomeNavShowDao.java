package dao;

import entity.BlogContent;

import java.util.List;

public interface HomeNavShowDao {
    //Home 微博内容分类导航条---DJN
    List<BlogContent> AllBlog();
    List<BlogContent> OriginalBlog();
    List<BlogContent> PicBlog();
    List<BlogContent> VideoBlog();
    List<BlogContent> MusicBlog();
}
