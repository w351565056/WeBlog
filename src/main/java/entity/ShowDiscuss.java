package entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShowDiscuss {
    private String USER_NAME;
    private String HEAD_IMG;
    private BigDecimal DISCUSS_ID;
    private BigDecimal BLOG_ID;
    private BigDecimal USER_ID;
    private String DISCUSS_TEXT;
    private String DISCUSS_IMG;
    private BigDecimal PRE_USER_ID;
    private Date CREATE_DATE_TIME;
    private Date MODIFY_DATE_TIME;

    public Date getMODIFY_DATE_TIME() {
        return MODIFY_DATE_TIME;
    }

    public void setMODIFY_DATE_TIME(Date MODIFY_DATE_TIME) {
        this.MODIFY_DATE_TIME = MODIFY_DATE_TIME;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getHEAD_IMG() {
        return HEAD_IMG;
    }

    public void setHEAD_IMG(String HEAD_IMG) {
        this.HEAD_IMG = HEAD_IMG;
    }

    public BigDecimal getDISCUSS_ID() {
        return DISCUSS_ID;
    }

    public void setDISCUSS_ID(BigDecimal DISCUSS_ID) {
        this.DISCUSS_ID = DISCUSS_ID;
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

    public String getDISCUSS_TEXT() {
        return DISCUSS_TEXT;
    }

    public void setDISCUSS_TEXT(String DISCUSS_TEXT) {
        this.DISCUSS_TEXT = DISCUSS_TEXT;
    }

    public String getDISCUSS_IMG() {
        return DISCUSS_IMG;
    }

    public void setDISCUSS_IMG(String DISCUSS_IMG) {
        this.DISCUSS_IMG = DISCUSS_IMG;
    }

    public BigDecimal getPRE_USER_ID() {
        return PRE_USER_ID;
    }

    public void setPRE_USER_ID(BigDecimal PRE_USER_ID) {
        this.PRE_USER_ID = PRE_USER_ID;
    }

    public Date getCREATE_DATE_TIME() {
        return CREATE_DATE_TIME;
    }

    public void setCREATE_DATE_TIME(Date CREATE_DATE_TIME) {
        this.CREATE_DATE_TIME = CREATE_DATE_TIME;
    }




}
