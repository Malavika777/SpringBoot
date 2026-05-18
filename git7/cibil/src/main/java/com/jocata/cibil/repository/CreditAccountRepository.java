package com.jocata.cibil.repository;

import com.jocata.cibil.model.CreditAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount, Integer> {
    List<CreditAccount> findByCustomerCusId(int cusId);

}
