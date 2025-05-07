package com.digrazia.kafka;

import com.digrazia.model.dto.PrenotazioneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneProducer {

    private static final String TOPIC = "prenotazioni";

    @Autowired
    private KafkaTemplate<String, PrenotazioneDTO> kafkaTemplate;

    public void invia(PrenotazioneDTO prenotazione) {
        kafkaTemplate.send(TOPIC, prenotazione);
    }
}
