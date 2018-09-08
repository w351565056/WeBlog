package entity;

import java.math.BigDecimal;
import java.util.Date;

public class Report {
  private BigDecimal BLOG_ID;
  private String BLOG_TEXT;
  private String BLOG_IMG;
  private BigDecimal REPORT;
  private BigDecimal USER_ID;
  private String USER_NAME;
  private Date LOCK_STATE;

  public Report(){}

  public Report(BigDecimal BLOG_ID, String BLOG_TEXT, String BLOG_IMG, BigDecimal REPORT, BigDecimal USER_ID, String USER_NAME, Date LOCK_STATE) {
    this.BLOG_ID = BLOG_ID;
    this.BLOG_TEXT = BLOG_TEXT;
    this.BLOG_IMG = BLOG_IMG;
    this.REPORT = REPORT;
    this.USER_ID = USER_ID;
    this.USER_NAME = USER_NAME;
    this.LOCK_STATE = LOCK_STATE;
  }

  public BigDecimal getBLOG_ID() {
    return BLOG_ID;
  }

  public void setBLOG_ID(BigDecimal BLOG_ID) {
    this.BLOG_ID = BLOG_ID;
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

  public BigDecimal getREPORT() {
    return REPORT;
  }

  public void setREPORT(BigDecimal REPORT) {
    this.REPORT = REPORT;
  }

  public BigDecimal getUSER_ID() {
    return USER_ID;
  }

  public void setUSER_ID(BigDecimal USER_ID) {
    this.USER_ID = USER_ID;
  }

  public String getUSER_NAME() {
    return USER_NAME;
  }

  public void setUSER_NAME(String USER_NAME) {
    this.USER_NAME = USER_NAME;
  }

  public Date getLOCK_STATE() {
    return LOCK_STATE;
  }

  public void setLOCK_STATE(Date LOCK_STATE) {
    this.LOCK_STATE = LOCK_STATE;
  }
}
