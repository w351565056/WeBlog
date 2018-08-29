package entity;

import java.math.BigDecimal;
import java.util.Date;

public class BlogDiscuss {
    private BigDecimal DISCUSS_ID;
    private BigDecimal BLOG_ID;
    private BigDecimal USER_ID;
    String DISCUSS_TEXT;
    String DISCUSS_IMG;
    Date CREATE_DATE_TIME;
    Date MODIFY_DATE_TIME;
    private BigDecimal PREUSER_ID;


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

    public BigDecimal getPREUSER_ID() {
        return PREUSER_ID;
    }

    public void setPREUSER_ID(BigDecimal PREUSER_ID) {
        this.PREUSER_ID = PREUSER_ID;
    }


}
