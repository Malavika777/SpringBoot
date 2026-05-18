package com.jocata.cibil.controller;

import com.jocata.cibil.dto.CreditAccountDTO;
import com.jocata.cibil.model.CreditAccount;
import com.jocata.cibil.service.CreditAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-account")
public class CreditAccountController {

    @Autowired
    private CreditAccountService creditAccountService;

    @PostMapping("/add/{cusId}")
    public ResponseEntity<CreditAccount> createAccount(@PathVariable int cusId,@PathVariable String pan, @RequestBody CreditAccountDTO creditAccount) {
        return ResponseEntity.ok(creditAccountService.addCreditAccount(cusId, pan,creditAccount));
    }

    @GetMapping("/customer/{cusId}")
    public ResponseEntity<List<CreditAccount>> getAccountsByCustomer(@PathVariable int cusId,@PathVariable String pan) {
        return ResponseEntity.ok(creditAccountService.getAccountByCustomer(cusId,pan));
    }

    @GetMapping("/{accId}")
    public ResponseEntity<CreditAccount> getAccountById(@PathVariable int accId) {
        return ResponseEntity.ok(creditAccountService.getAccountById(accId));
    }

    @PutMapping("/update/{accId}")
    public ResponseEntity<CreditAccount> updateAccount(@PathVariable int accId, @RequestBody CreditAccountDTO updatedAccount) {
        return ResponseEntity.ok(creditAccountService.updateCreditAccount(accId, updatedAccount));
    }

    @DeleteMapping("/delete/{accId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accId) {
        creditAccountService.deleteCreditAccount(accId);
        return ResponseEntity.ok("Credit account deleted successfully");
    }
}

