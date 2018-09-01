package entity;

import java.math.BigDecimal;
import java.util.Date;

public class BlogCollect {
    private BigDecimal COLLECT_ID;
    private BigDecimal USER_ID;
    private BigDecimal BLOG_ID;
    private Date CREATE_DATE_TIME;
    private Date MODIFY_DATE_TIME;
    private BigDecimal NUMCOL;
    private BigDecimal USERID;

    public BigDecimal getNUMCOL() {
        return NUMCOL;
    }

    public void setNUMCOL(BigDecimal NUMCOL) {
        this.NUMCOL = NUMCOL;
    }

    public BigDecimal getUSERID() {
        return USERID;
    }

    public void setUSERID(BigDecimal USERID) {
        this.USERID = USERID;
    }



    public BigDecimal getCOLLECT_ID() {
        return COLLECT_ID;
    }

    public void setCOLLECT_ID(BigDecimal COLLECT_ID) {
        this.COLLECT_ID = COLLECT_ID;
    }

    public BigDecimal getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(BigDecimal USER_ID) {
        this.USER_ID = USER_ID;
    }

    public BigDecimal getBLOG_ID() {
        return BLOG_ID;
    }

    public void setBLOG_ID(BigDecimal BLOG_ID) {
        this.BLOG_ID = BLOG_ID;
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
