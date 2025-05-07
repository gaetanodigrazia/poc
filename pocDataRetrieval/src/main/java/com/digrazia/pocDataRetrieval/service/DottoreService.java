package com.digrazia.pocDataRetrieval.service;

import com.digrazia.pocDataRetrieval.model.entity.Dottore;
import java.util.List;

public interface DottoreService {
    List<Dottore> findAll();
}
