package com.digrazia.pocDataRetrieval.API.controller;

import com.digrazia.pocDataRetrieval.model.dto.DisponibilitaDTO;
import com.digrazia.pocDataRetrieval.service.DisponibilitaService;
import com.digrazia.pocDataRetrieval.service.impl.DisponibilitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/disponibilita")
public class DisponibilitaController {

    @Autowired
    private DisponibilitaServiceImpl service;

    @GetMapping
    public List<DisponibilitaDTO> getDisponibilita(
            @RequestParam(required = false) String dottoreId,
            @RequestParam(required = false) String prestazioneId) {

        if (dottoreId != null && prestazioneId != null) {
            return service.getByDottoreAndPrestazione(dottoreId, prestazioneId);
        }

        return service.getAll();
    }
}
