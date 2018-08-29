package entity;

import java.sql.Timestamp;
import java.util.Date;

public class BlogContent {
    private int  BLOG_ID;
    private int USER_iD;
    private String BLOG_TEXT;
    private String BLOG_IMG;
    private int BLOG_FORWARD;
    private int REPORT;
    private Timestamp CREATE_DATE_TIME;
    private Timestamp MODIFY_DATE_TIME;
    public int getBLOG_ID() {
        return BLOG_ID;
    }

    public void setBLOG_ID(int BLOG_ID) {
        this.BLOG_ID = BLOG_ID;
    }

    public int getUSER_iD() {
        return USER_iD;
    }

    public void setUSER_iD(int USER_iD) {
        this.USER_iD = USER_iD;
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

    public int getBLOG_FORWARD() {
        return BLOG_FORWARD;
    }

    public void setBLOG_FORWARD(int BLOG_FORWARD) {
        this.BLOG_FORWARD = BLOG_FORWARD;
    }

    public int getREPORT() {
        return REPORT;
    }

    public void setREPORT(int REPORT) {
        this.REPORT = REPORT;
    }

    public Timestamp getCREATE_DATE_TIME() {
        return CREATE_DATE_TIME;
    }

    public void setCREATE_DATE_TIME(Timestamp CREATE_DATE_TIME) {
        this.CREATE_DATE_TIME = CREATE_DATE_TIME;
    }

    public Timestamp getMODIFY_DATE_TIME() {
        return MODIFY_DATE_TIME;
    }

    public void setMODIFY_DATE_TIME(Timestamp MODIFY_DATE_TIME) {
        this.MODIFY_DATE_TIME = MODIFY_DATE_TIME;
    }

}
