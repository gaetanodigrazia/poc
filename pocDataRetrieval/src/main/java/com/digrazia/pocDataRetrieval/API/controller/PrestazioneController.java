
package com.digrazia.pocDataRetrieval.API.controller;

import com.digrazia.pocDataRetrieval.API.PrestazioneAPI;
import com.digrazia.pocDataRetrieval.model.entity.Prestazione;
import com.digrazia.pocDataRetrieval.service.impl.PrestazioneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prestazione")
public class PrestazioneController implements PrestazioneAPI {
    private final PrestazioneServiceImpl prestazioneService;

    @Autowired
    public PrestazioneController(PrestazioneServiceImpl prestazioneService) {
        this.prestazioneService = prestazioneService;

    }

    @GetMapping("/dottore/{dottoreId}")
    @CrossOrigin(origins = "http://http://127.0.0.1:8501")
    public List<Prestazione> findAllByDottore(@PathVariable String dottoreId) {
        List<Prestazione> prestazioneList = prestazioneService.findAllPrestazioniByDottore(dottoreId);
        return prestazioneList;
    }
}
