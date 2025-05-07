package com.digrazia.pocDataRetrieval.service.impl;


import com.digrazia.pocDataRetrieval.model.entity.Dottore;
import com.digrazia.pocDataRetrieval.repository.DottoreRepository;
import com.digrazia.pocDataRetrieval.service.DottoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DottoreServiceImpl implements DottoreService {

    @Autowired
    private DottoreRepository dottoreRepository;

    public List<Dottore> findAll() {
        return dottoreRepository.findAll();
    }
}
