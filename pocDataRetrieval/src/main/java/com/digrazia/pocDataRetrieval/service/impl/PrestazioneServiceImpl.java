
package com.digrazia.pocDataRetrieval.service.impl;


import com.digrazia.pocDataRetrieval.mapper.PrestazioneMapper;
import com.digrazia.pocDataRetrieval.model.dto.PrestazioneDTO;
import com.digrazia.pocDataRetrieval.model.entity.Prestazione;
import com.digrazia.pocDataRetrieval.repository.PrestazioneRepository;
import com.digrazia.pocDataRetrieval.service.PrestazioneService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestazioneServiceImpl implements PrestazioneService {

    private final PrestazioneRepository prestazioneRepository;


    @Autowired
    public PrestazioneServiceImpl(PrestazioneRepository prestazioneRepository) {
        this.prestazioneRepository = prestazioneRepository;
    }

    @Override
    public List<Prestazione> findAllPrestazioniByDottore(String dottoreId) {
        return prestazioneRepository.findAllByDottoreId(dottoreId);
    }

}
