package com.aadhaarmanagement.AadhaarManagement.controller;

import com.aadhaarmanagement.AadhaarManagement.bean.AadhaarResponse;
import com.aadhaarmanagement.AadhaarManagement.service.AadhaarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aadhaar")
public class AadhaarController {

    @Autowired
    private AadhaarService aadhaarService;

    @GetMapping("/all")
    public ResponseEntity<List<AadhaarResponse>> getAllAadhaars() {
        List<AadhaarResponse> aadhaars = aadhaarService.getAllAadhaars();
        return ResponseEntity.ok(aadhaars);
    }

    @GetMapping("/{aadhaarNo}")
    public ResponseEntity<AadhaarResponse> getAadhaarDetails(@PathVariable String aadhaarNo) {
        AadhaarResponse response = aadhaarService.getAadhaarByNumber(aadhaarNo);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
