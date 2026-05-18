package com.jocata.panservice.controller;

import com.jocata.panservice.response.PanResponse;
import com.jocata.panservice.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class PanController {

    @Autowired
    private PanService panService;

    @GetMapping("/getPanDetails/{panNumber}")

    public PanResponse getPanDetails(@PathVariable String panNumber){

        PanResponse response = panService.getPanDetails(panNumber);
        return response;
    }
    //http://localhost:8081/api/v1/getPanDetails/765318008
    //url to run this file
    @GetMapping("/getAll")
    public List<PanResponse> getAllPanDetails(){
        return panService.getAllPanDetails();

    }
}
