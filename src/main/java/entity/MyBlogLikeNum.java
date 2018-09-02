package entity;

import java.math.BigDecimal;
import java.util.Date;

public class MyBlogLikeNum {
    private BigDecimal LIKE_ID;
    private BigDecimal BLOG_ID;
    private BigDecimal USER_ID;
    private Date CREATE_DATE_TIME;
    private Date MODIFY_DATE_TIME;
    private BigDecimal NUMLIK;

    public BigDecimal getNUMLIK() {
        return NUMLIK;
    }

    public void setNUMLIK(BigDecimal NUMLIK) {
        this.NUMLIK = NUMLIK;
    }

    public BigDecimal getLIKE_ID() {
        return LIKE_ID;
    }

    public void setLIKE_ID(BigDecimal LIKE_ID) {
        this.LIKE_ID = LIKE_ID;
    }

    public BigDecimal getBLOG_ID() {
        return BLOG_ID;
    }

    public void setBLOG_ID(BigDecimal BLOG_ID) {
        this.BLOG_ID = BLOG_ID;
    }

    public BigDecimal getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(BigDecimal USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Date getCREATE_DATE_TIME() {
        return CREATE_DATE_TIME;
    }

    public void setCREATE_DATE_TIME(Date CREATE_DATE_TIME) {
        this.CREATE_DATE_TIME = CREATE_DATE_TIME;
    }

    public Date getMODIFY_DATE_TIME() {
        return MODIFY_DATE_TIME;
    }

    public void setMODIFY_DATE_TIME(Date MODIFY_DATE_TIME) {
        this.MODIFY_DATE_TIME = MODIFY_DATE_TIME;
    }
}
