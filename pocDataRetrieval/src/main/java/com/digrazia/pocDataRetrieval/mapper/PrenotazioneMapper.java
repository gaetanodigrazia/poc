package com.digrazia.pocDataRetrieval.mapper;

import com.digrazia.pocDataRetrieval.model.dto.PrenotazioneDTO;
import com.digrazia.pocDataRetrieval.model.entity.Prenotazione;

public class PrenotazioneMapper {
    public static PrenotazioneDTO toDTO(Prenotazione p) {
        PrenotazioneDTO dto = new PrenotazioneDTO();
        dto.setId(p.getId());
        dto.setUtenteId(p.getUtenteId());
        dto.setDisponibilitaId(p.getDisponibilitaId());
        dto.setData(p.getData());
        return dto;
    }
}
