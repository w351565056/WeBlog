package entity;

import java.math.BigDecimal;

public class BlogInfoQuery {
    private BigDecimal BlogCollectNum;
    private BigDecimal BlogTurnNum;
    private BigDecimal BlogTalkNum;
    private BigDecimal BlogLikeNum;

    public BigDecimal getBlogCollectNum() {
        return BlogCollectNum;
    }

    public void setBlogCollectNum(BigDecimal blogCollectNum) {
        BlogCollectNum = blogCollectNum;
    }

    public BigDecimal getBlogTurnNum() {
        return BlogTurnNum;
    }

    public void setBlogTurnNum(BigDecimal blogTurnNum) {
        BlogTurnNum = blogTurnNum;
    }

    public BigDecimal getBlogTalkNum() {
        return BlogTalkNum;
    }

    public void setBlogTalkNum(BigDecimal blogTalkNum) {
        BlogTalkNum = blogTalkNum;
    }

    public BigDecimal getBlogLikeNum() {
        return BlogLikeNum;
    }

    public void setBlogLikeNum(BigDecimal blogLikeNum) {
        BlogLikeNum = blogLikeNum;
    }
}
