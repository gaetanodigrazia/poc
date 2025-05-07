
package com.digrazia.pocDataRetrieval.repository;

import com.digrazia.pocDataRetrieval.model.dto.PrestazioneDTO;
import com.digrazia.pocDataRetrieval.model.entity.Prestazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestazioneRepository extends JpaRepository<Prestazione, String> {

    @Query("""
    SELECT DISTINCT p
    FROM Disponibilita d
    JOIN d.prestazione p
    WHERE d.dottore.id = :dottoreId
""")
    List<Prestazione> findAllByDottoreId(@Param("dottoreId") String dottoreId);

}
