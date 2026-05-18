package com.aadhaarmanagement.AadhaarManagement.service;

import com.aadhaarmanagement.AadhaarManagement.bean.AadhaarResponse;

import java.util.List;

public interface AadhaarService {
    List<AadhaarResponse> getAllAadhaars();
    AadhaarResponse getAadhaarByNumber(String aadhaarNo);
}
