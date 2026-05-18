package com.jocata.cibil.service;

import com.jocata.cibil.dto.EnquiryDTO;
import com.jocata.cibil.model.Enquiry;

import java.util.List;

public interface EnquiryService {

    Enquiry recordEnquiry(int cusId, EnquiryDTO enquriyDTO);
    List<Enquiry> getEnquiriesByCustomer(int cusId);
    List<Enquiry> getEnquiriesInDateRange(int cusId,String startDate,String endDate);
    long countRecentEnquiries(int cusId,String monthYear);
}
