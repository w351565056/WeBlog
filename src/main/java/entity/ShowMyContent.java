package entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShowMyContent {
    private  String USER_NAME;
    private  String HEAD_IMG;
    private BigDecimal  BLOG_ID;
    private BigDecimal USER_ID;
    private String BLOG_TEXT;
    private String BLOG_IMG;
    private BigDecimal BLOG_FORWARD;
    private BigDecimal REPORT;
    private Date CREATE_DATE_TIME;
    private Date MODIFY_DATE_TIME;
    private BigDecimal RON;
    private BigDecimal NUMM;
    private String TOP;
    private BigDecimal CNUM;

    public BigDecimal getCNUM() {
        return CNUM;
    }

    public void setCNUM(BigDecimal CNUM) {
        this.CNUM = CNUM;
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

    public String getBLOG_TEXT() {
        return BLOG_TEXT;
    }

    public void setBLOG_TEXT(String BLOG_TEXT) {
        this.BLOG_TEXT = BLOG_TEXT;
    }

    public String getBLOG_IMG() {
        return BLOG_IMG;
    }

    public void setBLOG_IMG(String BLOG_IMG) {
        this.BLOG_IMG = BLOG_IMG;
    }

    public BigDecimal getBLOG_FORWARD() {
        return BLOG_FORWARD;
    }

    public void setBLOG_FORWARD(BigDecimal BLOG_FORWARD) {
        this.BLOG_FORWARD = BLOG_FORWARD;
    }

    public BigDecimal getREPORT() {
        return REPORT;
    }

    public void setREPORT(BigDecimal REPORT) {
        this.REPORT = REPORT;
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

    public BigDecimal getRON() {
        return RON;
    }

    public void setRON(BigDecimal RON) {
        this.RON = RON;
    }

    public BigDecimal getNUMM() {
        return NUMM;
    }

    public void setNUMM(BigDecimal NUMM) {
        this.NUMM = NUMM;
    }

    public String getTOP() {
        return TOP;
    }

    public void setTOP(String TOP) {
        this.TOP = TOP;
    }
}
