package com.jocata.cibil.controller;

import com.jocata.cibil.dto.PaymentHistoryDTO;
import com.jocata.cibil.model.PaymentHistory;
import com.jocata.cibil.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-history")
public class PaymentHistoryController {

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @PostMapping("/add/{accId}")
    public PaymentHistory addPaymentHistory(@PathVariable int accId, @RequestBody PaymentHistoryDTO historyDTO) {
        return paymentHistoryService.addPaymentHistory(accId, historyDTO);
    }

    @GetMapping("/{accId}")
    public List<PaymentHistory> getByAccount(@PathVariable int accId) {
        return paymentHistoryService.getPaymentHistoryByAccount(accId);
    }

    @GetMapping("/{accId}/{monthYear}")
    public PaymentHistory getByMonth(@PathVariable int accId, @PathVariable String monthYear) {
        return paymentHistoryService.getPaymentHistory(accId, monthYear);
    }

    @DeleteMapping("/delete/{hisId}")
    public String deleteHistory(@PathVariable int hisId) {
        paymentHistoryService.deletePaymentHistory(hisId);
        return "Deleted successfully";
    }
}
