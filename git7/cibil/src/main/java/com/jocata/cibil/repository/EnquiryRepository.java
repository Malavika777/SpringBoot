package com.jocata.cibil.repository;

import com.jocata.cibil.model.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {
    List<Enquiry> findByCustomerCusId(int cusId);

}
