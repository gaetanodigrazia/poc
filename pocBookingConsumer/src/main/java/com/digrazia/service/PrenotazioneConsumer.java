
package com.digrazia.service;


import com.digrazia.entity.Prenotazione;
import com.digrazia.model.dto.PrenotazioneDTO;
import com.digrazia.repository.PrenotazioneRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneConsumer {

    private final PrenotazioneRepository repository;

    public PrenotazioneConsumer(PrenotazioneRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "prenotazioni", groupId = "prenotazione-consumer")
    public void consuma(PrenotazioneDTO dto) {
        Prenotazione p = new Prenotazione();
        p.setId(dto.getId());
        p.setUtenteId(dto.getUtenteId());
        p.setDisponibilitaId(dto.getDisponibilitaId());
        p.setData(dto.getData());
        repository.save(p);
    }
}
