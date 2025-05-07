package com.digrazia.pocDataRetrieval.service;

import com.digrazia.pocDataRetrieval.model.dto.PrestazioneDTO;
import com.digrazia.pocDataRetrieval.model.entity.Prestazione;

import java.util.List;

public interface PrestazioneService {
    List<Prestazione> findAllPrestazioniByDottore(String dottoreId);
}
