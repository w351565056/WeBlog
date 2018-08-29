package impl;

import dao.ShowContentDao;
import entity.BlogContent;
import util.BaseDao;

import java.util.List;

public class ShowContentDaoImpl extends BaseDao<BlogContent> implements ShowContentDao {
    @Override
    public List<BlogContent> ShowContent(int i) {
        return executeQuery("select * from BLOG_CONTENT where BLOG_ID < ?",new Object[]{(i+1)});
    }

    @Override
    public List<BlogContent> ShowContent(String str, int i) {
        return null;
    }

    @Override
    public List<BlogContent> ShowContent() {
        return null;
    }
}
