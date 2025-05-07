package com.digrazia.API.controller;

import com.digrazia.kafka.PrenotazioneProducer;
import com.digrazia.model.dto.PrenotazioneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneProducer producer;

    @PostMapping
    public void inviaPrenotazione(@RequestBody PrenotazioneDTO prenotazione) {
        producer.invia(prenotazione);
    }
}
