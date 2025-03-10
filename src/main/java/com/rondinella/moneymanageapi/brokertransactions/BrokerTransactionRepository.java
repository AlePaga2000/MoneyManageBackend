package com.rondinella.moneymanageapi.brokertransactions;

import com.rondinella.moneymanageapi.brokertransactions.BrokerTransaction;
import com.rondinella.moneymanageapi.brokertransactions.BrokerTransactionId;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Hidden
public interface BrokerTransactionRepository extends JpaRepository<BrokerTransaction, BrokerTransactionId> {
  @Query("SELECT DISTINCT t.isin FROM BrokerTransaction t")
  List<String> findDistinctIsin();

  @Query("SELECT COALESCE(SUM(t.quantity), 0) FROM BrokerTransaction t WHERE t.isin = :isin")
  BigDecimal totalQuantityByIsin(@Param("isin") String isin);

  @Query("SELECT COALESCE(SUM(t.quantity), 0) FROM BrokerTransaction t WHERE t.isin = :isin AND t.datetime <= :datetime")
  BigDecimal totalQuantityByIsinGreaterThan(@Param("isin") String isin, @Param("datetime")Timestamp datetime);
}