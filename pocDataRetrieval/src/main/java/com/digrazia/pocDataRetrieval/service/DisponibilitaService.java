package com.digrazia.pocDataRetrieval.service;

import com.digrazia.pocDataRetrieval.model.dto.DisponibilitaDTO;

import java.util.List;

public interface DisponibilitaService {
    List<DisponibilitaDTO> getAll();
    List<DisponibilitaDTO> getByDottoreAndPrestazione(String dottoreId, String prestazioneId);
}
