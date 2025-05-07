package com.digrazia.pocDataRetrieval.API;

import com.digrazia.pocDataRetrieval.model.dto.PrestazioneDTO;
import com.digrazia.pocDataRetrieval.model.entity.Prestazione;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PrestazioneAPI {

    List<Prestazione> findAllByDottore(String dottoreId);
}
