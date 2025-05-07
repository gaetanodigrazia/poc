package com.digrazia.pocDataRetrieval.API;

import com.digrazia.pocDataRetrieval.model.dto.EsitoDTO;
import com.digrazia.pocDataRetrieval.model.entity.Esito;
import com.digrazia.pocDataRetrieval.repository.EsitoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class EsitoController {

    private final EsitoRepository repository;

    public EsitoController(EsitoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/esiti")
    public List<EsitoDTO> getAll() {
        return repository.findAll().stream().map(e -> {
            EsitoDTO dto = new EsitoDTO();
            dto.setId(e.getId());
            dto.setPrenotazioneId(e.getPrenotazioneId());
            dto.setDescrizione(e.getDescrizione());
            dto.setPrescrizioni(e.getPrescrizioni());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping("/esiti")
    public ResponseEntity<Void> saveEsito(@RequestBody EsitoDTO esitoDTO) {
        Esito esito = new Esito();
        esito.setId(UUID.randomUUID().toString());
        esito.setDescrizione(esitoDTO.getDescrizione());
        esito.setPrescrizioni(esitoDTO.getPrescrizioni());
        esito.setPrenotazioneId(esitoDTO.getPrenotazioneId());
        repository.save(esito);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/esiti/{id}")
    public ResponseEntity<Void> aggiornaEsito(@PathVariable String id, @RequestBody EsitoDTO dto) {
        Optional<Esito> esitoOpt = repository.findById(id);
        if (esitoOpt.isPresent()) {
            Esito esito = esitoOpt.get();
            esito.setDescrizione(dto.getDescrizione());
            esito.setPrescrizioni(dto.getPrescrizioni());
            repository.save(esito);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/esiti/{id}")
    public ResponseEntity<Void> eliminaEsito(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
