package entity;

import java.math.BigDecimal;
import java.util.Date;

public class BlogForward {
    private BigDecimal FORWARD_ID;
    private BigDecimal BLOG_ID;
    private BigDecimal USER_ID;
    private Date CREATE_DATE_TIME;
    private Date MODIFY_DATE_TIME;

    public BigDecimal getFORWARD_ID() {
        return FORWARD_ID;
    }

    public void setFORWARD_ID(BigDecimal FORWARD_ID) {
        this.FORWARD_ID = FORWARD_ID;
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
