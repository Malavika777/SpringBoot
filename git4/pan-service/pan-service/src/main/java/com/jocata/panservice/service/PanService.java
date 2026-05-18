package com.jocata.panservice.service;

import com.jocata.panservice.response.PanResponse;

import java.util.List;

public interface PanService {

    public PanResponse getPanDetails(String panNumber);
    public List<PanResponse> getAllPanDetails();
}
