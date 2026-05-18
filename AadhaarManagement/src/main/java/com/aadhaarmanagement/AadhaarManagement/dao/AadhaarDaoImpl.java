package com.aadhaarmanagement.AadhaarManagement.dao;

import com.aadhaarmanagement.AadhaarManagement.bean.AadhaarResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

@Repository
public class AadhaarDaoImpl implements AadhaarDao {

    private final List<AadhaarResponse> aadhaarList;

    public AadhaarDaoImpl() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/test.json");

            if (inputStream == null) {
                throw new RuntimeException("test.json not found");
            }

            aadhaarList = mapper.readValue(inputStream, new TypeReference<List<AadhaarResponse>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Aadhaar data from test.json", e);
        }
    }

    public List<AadhaarResponse> findAll() {
        return aadhaarList;
    }

    public AadhaarResponse findByAadhaarNo(String aadhaarNo) {
        return aadhaarList.stream()
                .filter(a -> a.getAadhaarNo().equals(aadhaarNo))
                .findFirst()
                .orElse(null);
    }
}
