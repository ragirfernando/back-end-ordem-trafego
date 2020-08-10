package com.ordemtrafego.service;

import com.ordemtrafego.domain.Condutor;
import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.exceptions.DatabaseException;
import com.ordemtrafego.exceptions.ResourceNotFoundException;
import com.ordemtrafego.repository.CondutorRepository;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;

    @Autowired
    private OrdemTrafegoRepository ordemTrafegoRepository;

    public List<Condutor> listarCondutores( ) {
        return condutorRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));


    }

    public List<Condutor> listarCondutoresCategoriaCnh(String categoriaCnh) {
        return condutorRepository.listarCondutoresCategoriaCnh(categoriaCnh);
    }

    public Condutor buscarCondutorId(Integer id) {
        Optional<Condutor> condutor = null;
        try {
            condutor = condutorRepository.findById(id);
            return condutor.get();
        } catch (NoSuchElementException noSuchElementException) {
            return condutor.orElseThrow(() -> new ResourceNotFoundException(id));
        }
    }

    public Condutor inserirCondutor(Condutor condutor) {
            return condutorRepository.save(condutor);
    }

    public String deletarCondutor(Integer id) {
        try {
            condutorRepository.deleteById(id);
            return "Condutor excluido com sucesso!";
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return "Condutor não pode ser excluido";
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            return "Condutor não pode ser excluido";
            /*throw new DatabaseException(dataIntegrityViolationException.getMessage());*/
        }
    }

    public Condutor atualizarCondutor(Condutor condutor) {
        return condutorRepository.save(condutor);
    }

    public Condutor buscaCondutorNome(String nome) {
        Optional<Condutor> condutor = null;
        try {
            condutor = Optional.ofNullable(condutorRepository.buscaCondutorNome(nome));
            return condutor.get();
        } catch (NoSuchElementException noSuchElementException) {
            return condutor.orElseThrow(() -> new ResourceNotFoundException(nome));
        }
    }

    public List<OrdemTrafego> listarOrdensTrafegoCondutor(Integer id) {
        Optional<List<OrdemTrafego>> ordensTrafego = null;
        try {
            ordensTrafego = Optional.ofNullable(ordemTrafegoRepository.listarOrdensTrafegoCondutor(id));
            return ordensTrafego.get();
        }catch (NoSuchElementException noSuchElementException) {
            return ordensTrafego.orElseThrow(() -> new ResourceNotFoundException(id));
        }
    }
}
