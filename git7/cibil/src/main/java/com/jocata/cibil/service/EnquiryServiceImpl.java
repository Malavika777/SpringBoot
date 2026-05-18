package com.jocata.cibil.service;

import com.jocata.cibil.dto.EnquiryDTO;
import com.jocata.cibil.model.Enquiry;
import com.jocata.cibil.model.Customer;
import com.jocata.cibil.repository.CustomerRepository;
import com.jocata.cibil.repository.EnquiryRepository;
import com.jocata.cibil.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Enquiry recordEnquiry(int cusId, EnquiryDTO enquriyDTO) {
        Customer c = customerRepository.findById(cusId).orElse(null);
        if (c == null) throw new IllegalArgumentException("Customer not found");
        Enquiry e = new Enquiry();
        e.setCustomer(c);
        e.setInstitutionName(enquriyDTO.getInstitutionName());
        e.setEnqPurpose(enquriyDTO.getEnquiryPurpose());
        if (enquriyDTO.getEnquiryDate() != null) {
            e.setEnquiryDate(Date.valueOf(enquriyDTO.getEnquiryDate()));
        }
        return enquiryRepository.save(e);
    }

    @Override
    public List<Enquiry> getEnquiriesByCustomer(int cusId) {
        return enquiryRepository.findByCustomerCusId(cusId);
    }

    @Override
    public List<Enquiry> getEnquiriesInDateRange(int cusId, String startDate, String endDate) {
        List<Enquiry> list = getEnquiriesByCustomer(cusId);
        java.sql.Date start = java.sql.Date.valueOf(startDate);
        java.sql.Date end = java.sql.Date.valueOf(endDate);
        return list.stream()
                .filter(e -> e.getEnquiryDate() != null && !e.getEnquiryDate().before(start) && !e.getEnquiryDate().after(end))
                .toList();
    }

    @Override
    public long countRecentEnquiries(int cusId, String monthYear) {
        List<Enquiry> list = getEnquiriesByCustomer(cusId);
        return list.stream().filter(e -> {
            if (e.getEnquiryDate() == null) return false;
            String ym = e.getEnquiryDate().toString().substring(0, 7); // gives "YYYY-MM"
            return ym.equals(monthYear);
        }).count();
    }
}
