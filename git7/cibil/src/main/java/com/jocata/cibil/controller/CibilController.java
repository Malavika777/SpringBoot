package com.jocata.cibil.controller;

import com.jocata.cibil.model.Customer;
import com.jocata.cibil.request.CibilRequestPayload;
import com.jocata.cibil.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cibil")
public class CibilController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/notifyCibilData")
    public String notifyCibilData(@RequestBody CibilRequestPayload payload) {
        customerService.saveCibilData(payload);
        return "Received and saved CIBIL data for customer: " + payload.getCustomer().getFullName();
    }

    @GetMapping("/getCustomerDetails")
    public ResponseEntity<Customer> getCustomerDetails(
            @RequestParam String panNumber,
            @RequestParam String adhaarNumber) {

        Customer customer = customerService.getCustomerByPanAndAadhaar(panNumber, adhaarNumber);

        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}