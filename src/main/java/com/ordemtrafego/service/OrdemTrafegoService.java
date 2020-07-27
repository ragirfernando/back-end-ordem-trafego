package com.ordemtrafego.service;

import com.ordemtrafego.repository.OrdemTrafegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemTrafegoService {

    @Autowired
    private OrdemTrafegoRepository ordemTrafegoRepository;
}
