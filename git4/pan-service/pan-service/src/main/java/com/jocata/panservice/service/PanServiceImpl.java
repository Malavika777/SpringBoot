package com.jocata.panservice.service;

import com.jocata.panservice.dao.PanDao;
import com.jocata.panservice.dao.PanDaoImpl;
import com.jocata.panservice.entity.PanEntity;
import com.jocata.panservice.response.PanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanServiceImpl implements PanService {

    @Autowired
    PanDao panDao;

    public PanResponse getPanDetails(String panNumber) {

        PanEntity panEntity = panDao.getPanDetails(panNumber);

        PanResponse response = new PanResponse();

        response.setId(panEntity.getId());
        response.setPanNumber(panEntity.getPanNumber());
        response.setFirstName(panEntity.getFirstName());
        response.setLastName(panEntity.getLastName());
        response.setDob(panEntity.getDob());
        response.setStatus(panEntity.getStatus());

        return  response;
    }

    public List<PanResponse> getAllPanDetails() {
        List<PanEntity> panEntityList = panDao.getAllPanDetails();
        List<PanResponse> panResponseList = new ArrayList<>();

        for (PanEntity panEntity : panEntityList) {
            PanResponse panResponse = new PanResponse();
            panResponse.setId(panEntity.getId());
            panResponse.setPanNumber(panEntity.getPanNumber());
            panResponse.setFirstName(panEntity.getFirstName());
            panResponse.setLastName(panEntity.getLastName());
            panResponse.setDob(panEntity.getDob());
            panResponse.setStatus(panEntity.getStatus());
            panResponseList.add(panResponse);
        }
        return  panResponseList;
    }
}

