package com.jocata.panservice.dao;

import com.jocata.panservice.entity.PanEntity;

import java.util.List;


public interface PanDao {

    public PanEntity getPanDetails(String panNumber);
    public List<PanEntity> getAllPanDetails();


}
