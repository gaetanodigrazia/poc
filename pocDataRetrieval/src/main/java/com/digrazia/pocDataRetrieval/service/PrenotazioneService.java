package com.digrazia.pocDataRetrieval.service;

import com.digrazia.pocDataRetrieval.mapper.PrenotazioneMapper;
import com.digrazia.pocDataRetrieval.model.dto.PrenotazioneDTO;
import com.digrazia.pocDataRetrieval.repository.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository repository;

    public PrenotazioneService(PrenotazioneRepository repository) {
        this.repository = repository;
    }

    public List<PrenotazioneDTO> findAll() {
        return repository.findAll().stream()
            .map(PrenotazioneMapper::toDTO)
            .toList();
    }
}
