package com.jocata.cibil.service;

import com.jocata.cibil.dto.PaymentHistoryDTO;
import com.jocata.cibil.model.PaymentHistory;

import java.util.List;

public interface PaymentHistoryService {

    PaymentHistory addPaymentHistory(int accId, PaymentHistoryDTO historyDTO);
    List<PaymentHistory> getPaymentHistoryByAccount(int accId);
    PaymentHistory getPaymentHistory(int accId,String monthYear);
    List<PaymentHistory> getLatePaymentsByCustomer(int CusId);
    void deletePaymentHistory(int hisId);
}
