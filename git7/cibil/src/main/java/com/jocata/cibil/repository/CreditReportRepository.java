package com.jocata.cibil.repository;

import com.jocata.cibil.model.CreditReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditReportRepository extends JpaRepository<CreditReport, Integer> {
    Optional<CreditReport> findByReportId(Integer reportId);
    Optional<CreditReport> findByContact(String contact);
}
