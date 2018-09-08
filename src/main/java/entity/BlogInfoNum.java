package entity;

import java.math.BigDecimal;

public class BlogInfoNum {
    BigDecimal collectNum;
    BigDecimal forwardNum;
    BigDecimal discussNum;
    BigDecimal likeNum;

    public BigDecimal getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(BigDecimal collectNum) {
        this.collectNum = collectNum;
    }

    public BigDecimal getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(BigDecimal forwardNum) {
        this.forwardNum = forwardNum;
    }

    public BigDecimal getDiscussNum() {
        return discussNum;
    }

    public void setDiscussNum(BigDecimal discussNum) {
        this.discussNum = discussNum;
    }

    public BigDecimal getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(BigDecimal likeNum) {
        this.likeNum = likeNum;
    }
}
