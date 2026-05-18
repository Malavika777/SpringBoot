package com.jocata.cibil.service;

import com.jocata.cibil.dto.CreditAccountDTO;
import com.jocata.cibil.model.CreditAccount;

import java.util.Date;
import java.util.List;

public interface CreditAccountService {

    CreditAccount addCreditAccount(int cusId, String pan, CreditAccountDTO accountDTO);
    List<CreditAccount> getAccountByCustomer(int CusId, String pan);
    CreditAccount getAccountById(int accId);
    CreditAccount updateCreditAccount(int accId,CreditAccountDTO accountDTO);
    void closeCreditAccount(int accId, Date closeDate);
    void deleteCreditAccount(int accId);


}
