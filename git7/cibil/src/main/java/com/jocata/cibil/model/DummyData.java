package com.jocata.cibil.model;

import java.util.List;

public class DummyData {


    }
//        if (cusId != 1) return null;
//
//        Customer customer = new Customer();
//        customer.setCusId(1);
//        customer.setFullName("Malu");
//        customer.setPanNumber("PAN1234");
//        customer.setAdhaarNumber("AADHAR1234");
//        customer.setEmail("malu@example.com");
//        customer.setMobile("9876543210");
//        customer.setDob("1998-05-12");
//        customer.setGender("F");
//        customer.setAddress("Chennai");
//
//        CreditAccount acc1 = new CreditAccount();
//        acc1.setAccId(201);
//        acc1.setCustomer(customer);
//        acc1.setInstitutionName("HDFC");
//        acc1.setAccType("Loan");
//        acc1.setCurrBal(500000);
//        acc1.setSanctAmount(700000);
//        acc1.setStatus("Active");
//
//        CreditAccount acc2 = new CreditAccount();
//        acc2.setAccId(202);
//        acc2.setCustomer(customer);
//        acc2.setInstitutionName("SBI");
//        acc2.setAccType("Savings");
//        acc2.setCurrBal(80000);
//        acc2.setSanctAmount(80000);
//        acc2.setStatus("Active");
//
//        PaymentHistory ph1 = new PaymentHistory();
//        ph1.setHisId(301);
//        ph1.setCreditAccount(acc1);
//        ph1.setMonthYear("2025-08");
//        ph1.setDpd("0");
//        ph1.setRemark("OnTime");
//
//        PaymentHistory ph2 = new PaymentHistory();
//        ph2.setHisId(302);
//        ph2.setCreditAccount(acc1);
//        ph2.setMonthYear("2025-09");
//        ph2.setDpd("1");
//        ph2.setRemark("LateBy1Day");
//
//        PaymentHistory ph3 = new PaymentHistory();
//        ph3.setHisId(303);
//        ph3.setCreditAccount(acc2);
//        ph3.setMonthYear("2025-08");
//        ph3.setDpd("0");
//        ph3.setRemark("OnTime");
//
//        acc1.setPaymentHistory(List.of(ph1, ph2));
//        acc2.setPaymentHistory(List.of(ph3));
//
//        Enquiry e1 = new Enquiry();
//        e1.setEnqId(401);
//        e1.setCustomer(customer);
//        e1.setInstitutionName("Axis");
//        e1.setEnqPurpose("CarLoan");
//        e1.setEnqDate("2025-09-15");
//
//        Enquiry e2 = new Enquiry();
//        e2.setEnqId(402);
//        e2.setCustomer(customer);
//        e2.setInstitutionName("ICICI");
//        e2.setEnqPurpose("HomeLoan");
//        e2.setEnqDate("2025-09-18");
//
//        customer.setCreditAccounts(List.of(acc1, acc2));
//        customer.setEnquiries(List.of(e1, e2));
//
//        return customer;
//    }
//}