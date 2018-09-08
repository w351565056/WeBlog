package entity;

import java.math.BigDecimal;

public class CountBB {
  private BigDecimal BB;
  public CountBB(){}

  public CountBB(BigDecimal BB) {
    this.BB = BB;
  }

  public BigDecimal getBB() {
    return BB;
  }

  public void setBB(BigDecimal BB) {
    this.BB = BB;
  }
}
