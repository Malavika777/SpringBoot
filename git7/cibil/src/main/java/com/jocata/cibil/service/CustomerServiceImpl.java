package com.jocata.cibil.service;

import com.jocata.cibil.model.*;
import com.jocata.cibil.repository.*;
import com.jocata.cibil.request.CibilRequestPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CreditReportRepository creditReportRepository;
    private final CreditAccountRepository creditAccountRepository;
    private final EnquiryRepository enquiryRepository;
    private final PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CreditReportRepository creditReportRepository,
                               CreditAccountRepository creditAccountRepository,
                               EnquiryRepository enquiryRepository,
                               PaymentHistoryRepository paymentHistoryRepository) {
        this.customerRepository = customerRepository;
        this.creditReportRepository = creditReportRepository;
        this.creditAccountRepository = creditAccountRepository;
        this.enquiryRepository = enquiryRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    @Override
    @Transactional
    public void saveCibilData(CibilRequestPayload payload) {
        if (payload == null || payload.getCustomer() == null) {
            throw new IllegalArgumentException("Payload or Customer cannot be null");
        }

        Customer incoming = payload.getCustomer();

        Customer persisted = customerRepository.findByPanNumber(incoming.getPanNumber());
        if (persisted == null && incoming.getAdhaarNumber() != null) {
            persisted = customerRepository.findByAdhaarNumber(incoming.getAdhaarNumber());
        }

        if (persisted == null) {
            persisted = customerRepository.save(incoming);
        } else {
            persisted.setFullName(incoming.getFullName());
            persisted.setEmail(incoming.getEmail());
            persisted.setMobile(incoming.getMobile());
            persisted.setAddress(incoming.getAddress());
            persisted.setDob(incoming.getDob());
            persisted.setGender(incoming.getGender());
            persisted = customerRepository.save(persisted);
        }

        if (payload.getCreditReports() != null) {
            for (CreditReport cr : payload.getCreditReports()) {
                cr.setCustomer(persisted);
                creditReportRepository.save(cr);
            }
        }

        if (payload.getCreditAccounts() != null) {
            for (CreditAccount ca : payload.getCreditAccounts()) {
                ca.setCustomer(persisted);
                CreditAccount savedAcc = creditAccountRepository.save(ca);
                if (ca.getPaymentHistories() != null) {
                    for (PaymentHistory ph : ca.getPaymentHistories()) {
                        ph.setCreditAccount(savedAcc);
                        paymentHistoryRepository.save(ph);
                    }
                }
            }
        }

        if (payload.getEnquiries() != null) {
            for (Enquiry enq : payload.getEnquiries()) {
                enq.setCustomer(persisted);
                enquiryRepository.save(enq);
            }
        }
    }

    @Override
    public Customer getCustomerByPanAndAadhaar(String panNumber, String adhaarNumber) {
        return customerRepository.findByPanNumberAndAdhaarNumber(panNumber, adhaarNumber);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(int cusId) {
        Optional<Customer> opt = customerRepository.findById(cusId);
        return opt.orElse(null);
    }

    @Override
    public Customer getCustomerByPanOrAdhaar(String pan, String ahdaar) {
        Customer c = null;
        if (pan != null) c = customerRepository.findByPanNumber(pan);
        if (c == null && ahdaar != null) c = customerRepository.findByAdhaarNumber(ahdaar);
        return c;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int cusId, String pan, String ahdaar) {
        if (cusId > 0) {
            customerRepository.deleteById(cusId);
            return;
        }
        Customer toDelete = getCustomerByPanOrAdhaar(pan, ahdaar);
        if (toDelete != null) customerRepository.delete(toDelete);
    }

}
