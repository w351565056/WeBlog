package dao;

import entity.BlogInfoNum;

import java.math.BigDecimal;
import java.util.List;

public interface BlogInfoNumByBlogIdDao {
     List<BlogInfoNum> showInfoNum(BigDecimal blog_id);
}
