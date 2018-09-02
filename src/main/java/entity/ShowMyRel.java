package entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShowMyRel {
    private BigDecimal REL_ID;
    private BigDecimal FANS_ID;
    private BigDecimal ATTENTION_ID;
    private Date CREATE_DATE_TIME;
    private Date MODIFY_DATE_TIME;
    private BigDecimal FNUM;
    private BigDecimal ANUM;

    public BigDecimal getFNUM() {
        return FNUM;
    }

    public void setFNUM(BigDecimal FNUM) {
        this.FNUM = FNUM;
    }

    public BigDecimal getANUM() {
        return ANUM;
    }

    public void setANUM(BigDecimal ANUM) {
        this.ANUM = ANUM;
    }


    public BigDecimal getREL_ID() {
        return REL_ID;
    }

    public void setREL_ID(BigDecimal REL_ID) {
        this.REL_ID = REL_ID;
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
