package com.digrazia.pocDataRetrieval.repository;

import com.digrazia.pocDataRetrieval.model.entity.Disponibilita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibilitaRepository extends JpaRepository<Disponibilita, String> {

    List<Disponibilita> findByDottore_IdAndPrestazione_Id(String dottoreId, String prestazioneId);
}
