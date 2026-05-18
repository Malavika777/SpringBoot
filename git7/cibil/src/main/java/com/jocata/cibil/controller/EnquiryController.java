package com.jocata.cibil.controller;

import com.jocata.cibil.dto.EnquiryDTO;
import com.jocata.cibil.model.Enquiry;
import com.jocata.cibil.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/api/enquiry")
    public class EnquiryController {

        @Autowired
        private EnquiryService enquiryService;

        @PostMapping("/record/{cusId}")
        public ResponseEntity<Enquiry> recordEnquiry(@PathVariable int cusId, @RequestBody EnquiryDTO enquiryDTO) {
            Enquiry enquiry = enquiryService.recordEnquiry(cusId , enquiryDTO);
            return ResponseEntity.ok(enquiry);
        }

        @GetMapping("/customer/{cusId}")
        public ResponseEntity<List<Enquiry>> getEnquiriesByCustomer(@PathVariable int cusId) {
            List<Enquiry> list = enquiryService.getEnquiriesByCustomer(cusId);
            return ResponseEntity.ok(list);
        }

        @GetMapping("/range/{cusId}")
        public ResponseEntity<List<Enquiry>> getEnquiriesInDateRange(
                @PathVariable int cusId,
                @RequestParam String startDate,
                @RequestParam String endDate) {
            List<Enquiry> list = enquiryService.getEnquiriesInDateRange(cusId, startDate, endDate);
            return ResponseEntity.ok(list);
        }

        @GetMapping("/count/{cusId}")
        public ResponseEntity<Long> countRecentEnquiries(
                @PathVariable int cusId,
                @RequestParam String monthYear) {
            long count = enquiryService.countRecentEnquiries(cusId, monthYear);
            return ResponseEntity.ok(count);
        }
    }


