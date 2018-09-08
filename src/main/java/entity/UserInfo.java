package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserInfo implements Serializable {

    private BigDecimal USER_ID;
    private String USER_NAME;
    private String USER_PASS;
    private String PHONE_NO;
    private String TRUE_NAME;
    private String HEAD_IMG;
    private String GENDER;
    private String EMAIL;
    private String ADDRESS;
    private String BLOOD_TYPE;
    private Date BIRTHDAY;
    private String INTRO;
    private Date LOCK_STATE;
    private Date CREATE_DATE_TIME;
    private Date MODIFY_DATE_TIME;
    private String QQ;
    public UserInfo(){}
    //更新个人信息
    public UserInfo(String USER_NAME,String PHONE_NO,String TRUE_NAME,String GENDER,String EMAIL,String ADDRESS,String BLOOD_TYPE,Date BIRTHDAY,String QQ,String INTRO,BigDecimal USER_ID){
        this.USER_ID=USER_ID;
        this.USER_NAME=USER_NAME;
        this.PHONE_NO=PHONE_NO;
        this.TRUE_NAME=TRUE_NAME;
        this.GENDER=GENDER;
        this.EMAIL=EMAIL;
        this.ADDRESS=ADDRESS;
        this.BLOOD_TYPE=BLOOD_TYPE;
        this.BIRTHDAY=BIRTHDAY;
        this.QQ=QQ;
        this.INTRO=INTRO;
}
    public UserInfo(String USER_NAME){
        this.USER_NAME=USER_NAME;
    }

    public UserInfo(String USER_NAME,String USER_PASS){
        this.USER_NAME=USER_NAME;
        this.USER_PASS=USER_PASS;

    }

    public UserInfo(String USER_NAME,String USER_PASS,String PHONE_NO){
        this.USER_NAME=USER_NAME;
        this.USER_PASS=USER_PASS;
        this.PHONE_NO=PHONE_NO;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
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

    public String getUSER_PASS() {
        return USER_PASS;
    }

    public void setUSER_PASS(String USER_PASS) {
        this.USER_PASS = USER_PASS;
    }

    public String getPHONE_NO() {
        return PHONE_NO;
    }

    public void setPHONE_NO(String PHONE_NO) {
        this.PHONE_NO = PHONE_NO;
    }

    public String getTRUE_NAME() {
        return TRUE_NAME;
    }

    public void setTRUE_NAME(String TRUE_NAME) {
        this.TRUE_NAME = TRUE_NAME;
    }

    public String getHEAD_IMG() {
        return HEAD_IMG;
    }

    public void setHEAD_IMG(String HEAD_IMG) {
        this.HEAD_IMG = HEAD_IMG;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getBLOOD_TYPE() {
        return BLOOD_TYPE;
    }

    public void setBLOOD_TYPE(String BLOOD_TYPE) {
        this.BLOOD_TYPE = BLOOD_TYPE;
    }

    public Date getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(Date BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getINTRO() {
        return INTRO;
    }

    public void setINTRO(String INTRO) {
        this.INTRO = INTRO;
    }

    public Date getLOCK_STATE() {
        return LOCK_STATE;
    }

    public void setLOCK_STATE(Date LOCK_STATE) {
        this.LOCK_STATE = LOCK_STATE;
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
