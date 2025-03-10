package com.rondinella.moneymanageapi.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountSummaryDto {
  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ValueDatePair implements Comparable<ValueDatePair> {
    Date date;
    BigDecimal value;

    @Override
    public int compareTo(ValueDatePair other) {
      return this.date.compareTo(other.date);
    }
  }

  private String accountName;
  private List<ValueDatePair> summary;

  public void sortAccountsByDate() {
    Collections.sort(summary);
  }
}
