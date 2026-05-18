package com.aadhaarmanagement.AadhaarManagement.dao;

import com.aadhaarmanagement.AadhaarManagement.bean.AadhaarResponse;
import java.util.List;

public interface AadhaarDao {
    List<AadhaarResponse> findAll();
    AadhaarResponse findByAadhaarNo(String aadhaarNo);
}
