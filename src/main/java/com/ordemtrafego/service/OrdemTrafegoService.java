package com.ordemtrafego.service;

import com.ordemtrafego.domain.Condutor;
import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.domain.Veiculo;
import com.ordemtrafego.exceptions.DatabaseException;
import com.ordemtrafego.exceptions.ResourceNotFoundException;
import com.ordemtrafego.repository.CondutorRepository;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import com.ordemtrafego.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrdemTrafegoService {

    @Autowired
    private OrdemTrafegoRepository ordemTrafegoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CondutorRepository condutorRepository;

    public Condutor buscarCondutorId(Integer id) {
        Optional<Condutor> condutor = null;
        try {
            condutor = condutorRepository.findById(id);
            return condutor.get();
        } catch (NoSuchElementException noSuchElementException) {
            return condutor.orElseThrow(() -> new ResourceNotFoundException(id));
        }
    }

    public Veiculo buscarVeiculoId(Integer id) {
        Optional<Veiculo> veiculo = null;
        try {
            veiculo = veiculoRepository.findById(id);
            return veiculo.get();
        } catch (NoSuchElementException noSuchElementException) {
            return veiculo.orElseThrow(() -> new ResourceNotFoundException(id));
        }
    }

    public OrdemTrafego inserirOrdemTrafego(OrdemTrafego ordemTrafego) {
        return ordemTrafegoRepository.save(ordemTrafego);
    }

    public OrdemTrafego atualizarOrdemTrafego(OrdemTrafego ordemTrafego) {
        return ordemTrafegoRepository.save(ordemTrafego);
    }

    public void deletarOrdemTrafego(Integer id) {
        try {
            ordemTrafegoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DatabaseException(dataIntegrityViolationException.getMessage());
        }
    }

    public List<OrdemTrafego> listarOrdensTrafego(){
        return ordemTrafegoRepository.findAll();
    }


    public List<OrdemTrafego> listarOrdensTrafegoData(Date dataInicial, Date dataFinal){
        Optional<List<OrdemTrafego>> ordensTrafego = null;
        try {
            ordensTrafego = Optional.ofNullable(ordemTrafegoRepository.listarOrdensTrafegoData(dataInicial, dataFinal));
            return ordensTrafego.get();
        } catch (NoSuchElementException noSuchElementException) {
            return ordensTrafego.orElseThrow(() -> new ResourceNotFoundException(dataFinal));
        }
    }

    public List<OrdemTrafego> listarOrdensTrafegoCidadeOrigem(String cidadeOrigem){
        Optional<List<OrdemTrafego>> ordensTrafego = null;
        try {
            ordensTrafego = Optional.ofNullable(ordemTrafegoRepository.listarOrdensTrafegoCidadeOrigem(cidadeOrigem));
            return ordensTrafego.get();
        } catch (NoSuchElementException noSuchElementException) {
            return ordensTrafego.orElseThrow(() -> new ResourceNotFoundException(cidadeOrigem));
        }
    }

    public List<OrdemTrafego> listarOrdensTrafegoCidadeDestino(String cidadeDestino){
        Optional<List<OrdemTrafego>> ordensTrafego = null;
        try {
            ordensTrafego = Optional.ofNullable(ordemTrafegoRepository.listarOrdensTrafegoCidadeDestino(cidadeDestino));
            return ordensTrafego.get();
        } catch (NoSuchElementException noSuchElementException) {
            return ordensTrafego.orElseThrow(() -> new ResourceNotFoundException(cidadeDestino));
        }
    }
}
