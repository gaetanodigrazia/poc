package com.digrazia.pocDataRetrieval.API;

import com.digrazia.pocDataRetrieval.model.dto.PrenotazioneDTO;
import com.digrazia.pocDataRetrieval.service.PrenotazioneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PrenotazioneController {

    private final PrenotazioneService service;

    public PrenotazioneController(PrenotazioneService service) {
        this.service = service;
    }

    @GetMapping("/prenotazioni")
    public List<PrenotazioneDTO> getAll() {
        return service.findAll();
    }
}
