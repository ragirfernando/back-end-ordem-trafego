package com.ordemtrafego.service;

import com.ordemtrafego.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondutorService {
    
    @Autowired
    CondutorRepository condutorRepository;
    
    
}
