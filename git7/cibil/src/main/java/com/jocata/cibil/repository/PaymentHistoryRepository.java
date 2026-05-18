package com.jocata.cibil.repository;

import com.jocata.cibil.model.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Integer> {
    List<PaymentHistory> findByCreditAccountCustomerCusId(int cusId);
    List<PaymentHistory> findByCreditAccountAccId(Integer acctId);
    Optional<PaymentHistory> findByCreditAccountAccIdAndMonthYear(Integer accId, String monthYear);
    List<PaymentHistory> findByCreditAccountCustomerCusId(Integer cusId);

}