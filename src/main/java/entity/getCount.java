package entity;

import java.math.BigDecimal;

public class getCount {
    private BigDecimal USER_ID;
    private BigDecimal FANS_ID;
    private BigDecimal ATTENTION_ID;
    private BigDecimal COUNT;
    public getCount(){};

    public getCount(BigDecimal USER_ID) {
        this.USER_ID = USER_ID;

    }

    public BigDecimal getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(BigDecimal USER_ID) {
        this.USER_ID = USER_ID;
    }

    public BigDecimal getFANS_ID() {
        return FANS_ID;
    }

    public void setFANS_ID(BigDecimal FANS_ID) {
        this.FANS_ID = FANS_ID;
    }

    public BigDecimal getATTENTION_ID() {
        return ATTENTION_ID;
    }

    public void setATTENTION_ID(BigDecimal ATTENTION_ID) {
        this.ATTENTION_ID = ATTENTION_ID;
    }

    public BigDecimal getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(BigDecimal COUNT) {
        this.COUNT = COUNT;
    }
}
