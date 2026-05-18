package com.jocata.cibil.repository;

import com.jocata.cibil.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByPanNumberAndAdhaarNumber(String panNumber, String adhaarNumber);
    Customer findByPanNumber(String panNumber);
    Customer findByAdhaarNumber(String adhaarNumber);



}