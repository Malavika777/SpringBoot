package com.jocata.cibil.service;

import com.jocata.cibil.model.CreditReport;
import com.jocata.cibil.model.Customer;
import com.jocata.cibil.repository.CreditReportRepository;
import com.jocata.cibil.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditReportServiceImpl implements CreditReportService {

    @Autowired
    private CreditReportRepository creditReportRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CreditReport generateCreditReport(String pan) {
        CreditReport report = new CreditReport();
        //report.setCibilScore(750);
        return creditReportRepository.save(report);
    }

    @Override
    public CreditReport getcreditReportByControlNumber(int controlnum) {
        Optional<CreditReport> opt = creditReportRepository.findById(controlnum);
        return opt.orElse(null);
    }

}
