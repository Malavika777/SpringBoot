package com.aadhaarmanagement.AadhaarManagement.service;

import com.aadhaarmanagement.AadhaarManagement.bean.AadhaarResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class AadhaarServiceImpl implements AadhaarService {

    private List<AadhaarResponse> aadhaarList;

    public AadhaarServiceImpl() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/test.json");
            aadhaarList = mapper.readValue(inputStream, new TypeReference<List<AadhaarResponse>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AadhaarResponse> getAllAadhaars() {
        return aadhaarList;
    }

    public AadhaarResponse getAadhaarByNumber(String aadhaarNo) {
        return aadhaarList.stream()
                .filter(a -> a.getAadhaarNo().equals(aadhaarNo))
                .findFirst()
                .orElse(null);
    }
}
