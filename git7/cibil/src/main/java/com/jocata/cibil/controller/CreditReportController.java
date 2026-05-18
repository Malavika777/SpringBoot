package com.jocata.cibil.controller;

import com.jocata.cibil.model.CreditReport;
import com.jocata.cibil.service.CreditReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-report")
public class CreditReportController {

    @Autowired
    private CreditReportService creditReportService;

    @GetMapping("/generate/{pan}")
    public CreditReport generateReport(@PathVariable String pan) {
        return creditReportService.generateCreditReport(pan);
    }

    @GetMapping("/{controlNum}")
    public CreditReport getReport(@PathVariable int controlNum) {
        return creditReportService.getcreditReportByControlNumber(controlNum);
    }


}

