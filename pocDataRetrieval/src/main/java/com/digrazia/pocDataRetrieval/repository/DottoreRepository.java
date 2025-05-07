package com.digrazia.pocDataRetrieval.repository;

import com.digrazia.pocDataRetrieval.model.entity.Dottore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DottoreRepository extends JpaRepository<Dottore, Long> {
}
