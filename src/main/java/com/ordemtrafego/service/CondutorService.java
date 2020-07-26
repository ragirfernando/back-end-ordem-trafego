package com.ordemtrafego.service;

import com.ordemtrafego.domain.Condutor;
import com.ordemtrafego.exceptions.ResourceNotFoundException;
import com.ordemtrafego.repository.CondutorRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;

    private List<Condutor> condutors = new ArrayList<>();

    public List<Condutor> listarCondutores() {
        List<Condutor> condutores = new ArrayList<>();
        try {
            condutores = condutorRepository.findAll();
            return condutores;
        } catch (Exception exception) {
            return null;
        }
    }

    public Condutor buscarCondutorId(Integer id) {
        Optional<Condutor> condutor = null;
        try {
            condutor = condutorRepository.findById(id);
            return condutor.get();
        }catch (Exception  exception) {
            return condutor.orElseThrow(() -> new ResourceNotFoundException(id));
        }
    }

    public Condutor inserirCondutor(Condutor condutor) {

        return condutorRepository.save(condutor);
    }

    public void deletarCondutor(Integer id) {
        condutorRepository.deleteById(id);
    }

    public Condutor atualizarCondutor(Condutor condutor) {
       return condutorRepository.save(condutor);
    }
}
