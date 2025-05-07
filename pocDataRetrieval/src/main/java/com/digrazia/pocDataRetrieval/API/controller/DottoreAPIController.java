package com.digrazia.pocDataRetrieval.API.controller;

import com.digrazia.pocDataRetrieval.API.DottoreAPI;
import com.digrazia.pocDataRetrieval.model.entity.Dottore;
import com.digrazia.pocDataRetrieval.service.impl.DottoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dottore")
public class DottoreAPIController implements DottoreAPI {

    private final DottoreServiceImpl dottoreService;

    @Autowired
    public DottoreAPIController(DottoreServiceImpl dottoreService) {
        this.dottoreService = dottoreService;
    }


    @GetMapping
    public List<Dottore> findAll() {
        return dottoreService.findAll();
    }
}
