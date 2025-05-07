package com.digrazia.pocDataRetrieval.service.impl;

import com.digrazia.pocDataRetrieval.model.dto.DisponibilitaDTO;
import com.digrazia.pocDataRetrieval.model.entity.Disponibilita;
import com.digrazia.pocDataRetrieval.repository.DisponibilitaRepository;
import com.digrazia.pocDataRetrieval.service.DisponibilitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilitaServiceImpl implements DisponibilitaService {

    @Autowired
    private DisponibilitaRepository repo;

    @Override
    public List<DisponibilitaDTO> getAll() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public List<DisponibilitaDTO> getByDottoreAndPrestazione(String dottoreId, String prestazioneId) {
        return repo.findByDottore_IdAndPrestazione_Id(dottoreId, prestazioneId).stream()
                   .map(this::toDTO).toList();
    }

    private DisponibilitaDTO toDTO(Disponibilita d) {
        DisponibilitaDTO dto = new DisponibilitaDTO();
        dto.setId(d.getId());
        dto.setGiorno(d.getGiorno());
        dto.setOrario(d.getOrario());
        dto.setDottoreId(d.getDottore().getId());
        dto.setPrestazioneId(d.getPrestazione().getId());
        return dto;
    }
}
