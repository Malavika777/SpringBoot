package com.jocata.cibil.service;

import com.jocata.cibil.dto.CreditAccountDTO;
import com.jocata.cibil.model.CreditAccount;
import com.jocata.cibil.model.Customer;
import com.jocata.cibil.repository.CreditAccountRepository;
import com.jocata.cibil.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CreditAccountServiceImpl implements CreditAccountService {

    @Autowired
    private CreditAccountRepository creditAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CreditAccount addCreditAccount(int cusId, String pan, CreditAccountDTO accountDTO) {
        Customer customer = customerRepository.findById(cusId).orElse(null);
        if (customer == null) {
            customer = customerRepository.findByPanNumber(pan);
            if (customer == null) throw new IllegalArgumentException("Customer not found");
        }
        CreditAccount acc = new CreditAccount();
        acc.setCustomer(customer);
        acc.setInstitutionName(accountDTO.getInstitutionName());
        acc.setAccType(accountDTO.getAccType());
        acc.setAccNo((long) accountDTO.getAccNo());
        acc.setOwnership(accountDTO.getOwnership());
        acc.setStatus(accountDTO.getStatus());
        return creditAccountRepository.save(acc);
    }

    @Override
    public List<CreditAccount> getAccountByCustomer(int CusId, String pan) {
        return creditAccountRepository.findByCustomerCusId(CusId);
    }

    @Override
    public CreditAccount getAccountById(int accId) {
        Optional<CreditAccount> opt = creditAccountRepository.findById(accId);
        return opt.orElse(null);
    }

    @Override
    public CreditAccount updateCreditAccount(int accId, CreditAccountDTO accountDTO) {
        CreditAccount acc = getAccountById(accId);
        if (acc == null) throw new IllegalArgumentException("Account not found");
        acc.setInstitutionName(accountDTO.getInstitutionName());
        acc.setAccType(accountDTO.getAccType());
        acc.setAccNo((long) accountDTO.getAccNo());
        acc.setOwnership(accountDTO.getOwnership());
        acc.setStatus(accountDTO.getStatus());
        return creditAccountRepository.save(acc);
    }

    @Override
    public void closeCreditAccount(int accId, Date closeDate) {
        CreditAccount acc = getAccountById(accId);
        if (acc == null) throw new IllegalArgumentException("Account not found");
        acc.setCloseDate(closeDate != null ? closeDate : null);
        creditAccountRepository.save(acc);
    }

    @Override
    public void deleteCreditAccount(int accId) {
        creditAccountRepository.deleteById(accId);
    }
}
