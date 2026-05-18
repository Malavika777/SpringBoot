package com.jocata.cibil.service;

import com.jocata.cibil.dto.PaymentHistoryDTO;
import com.jocata.cibil.model.CreditAccount;
import com.jocata.cibil.model.PaymentHistory;
import com.jocata.cibil.repository.CreditAccountRepository;
import com.jocata.cibil.repository.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    private CreditAccountRepository creditAccountRepository;

    @Override
    public PaymentHistory addPaymentHistory(int accId, PaymentHistoryDTO historyDTO) {
        CreditAccount acc = creditAccountRepository.findById(accId).orElse(null);
        if (acc == null) throw new IllegalArgumentException("Account not found");
        PaymentHistory ph = new PaymentHistory();
        ph.setCreditAccount(acc);
        ph.setMonthYear(historyDTO.getMonthYear());
        ph.setDpd(historyDTO.getDpd());
        ph.setRemark(historyDTO.getRemark());
        return paymentHistoryRepository.save(ph);
    }

    @Override
    public List<PaymentHistory> getPaymentHistoryByAccount(int accId) {
        return paymentHistoryRepository.findByCreditAccountAccId(accId);
    }

    @Override
    public PaymentHistory getPaymentHistory(int accId, String monthYear) {
        Optional<PaymentHistory> opt = paymentHistoryRepository.findByCreditAccountAccIdAndMonthYear(accId, monthYear);
        return opt.orElse(null);
    }

    @Override
    public List<PaymentHistory> getLatePaymentsByCustomer(int CusId) {
        List<PaymentHistory> list = paymentHistoryRepository.findByCreditAccountCustomerCusId(CusId);
        return list.stream().filter(ph -> {
            try { return Integer.parseInt(ph.getDpd()) > 0; }
            catch (Exception e) { return false; }
        }).toList();
    }

    @Override
    public void deletePaymentHistory(int hisId) {
        paymentHistoryRepository.deleteById(hisId);
    }
}
