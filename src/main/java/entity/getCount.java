package entity;

import java.math.BigDecimal;

public class getCount {
    private BigDecimal FANS_ID;
    private BigDecimal ATTENTION_ID;
    private BigDecimal count;
    public getCount(){};
    public getCount(BigDecimal FANS_ID, BigDecimal ATTENTION_ID, BigDecimal count) {
        this.FANS_ID = FANS_ID;
        this.ATTENTION_ID = ATTENTION_ID;
        this.count = count;
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

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
