package dao;

import entity.getCount;

import java.math.BigDecimal;
import java.util.List;

public interface UserRelDao {
    List<getCount> getCountFans(BigDecimal USER_ID);
    List<getCount> getCountAttention(BigDecimal USER_ID);
    List<getCount> getCountFansA(BigDecimal USER_ID);
    List<getCount> getCountAttentionF(BigDecimal USER_ID);
    List<getCount> getCountAttentionBlog(BigDecimal USER_ID);
    List<getCount> getCountFansBlog(BigDecimal USER_ID);
    int insertAttention(BigDecimal FANS_ID, BigDecimal ATTENTION_ID);
    int deleteAttention(BigDecimal ATTENTION_ID,BigDecimal FANS_ID);
    List<getCount> QueryAttention(BigDecimal FANS_ID, BigDecimal ATTENTION_ID);
}
