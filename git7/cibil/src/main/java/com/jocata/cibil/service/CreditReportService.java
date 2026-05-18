package com.jocata.cibil.service;

import com.jocata.cibil.model.CreditReport;

public interface CreditReportService {

    CreditReport generateCreditReport(String pan);
    CreditReport getcreditReportByControlNumber(int controlnum);
}
