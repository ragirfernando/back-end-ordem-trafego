package com.ordemtrafego.service;

import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.domain.Veiculo;
import com.ordemtrafego.exceptions.DatabaseException;
import com.ordemtrafego.exceptions.ResourceNotFoundException;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import com.ordemtrafego.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private OrdemTrafegoRepository ordemTrafegoRepository;

    public Veiculo inserirVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(Integer id) {
        try {
            veiculoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DatabaseException(dataIntegrityViolationException.getMessage());
        }
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        //repository.findAll(Sort.by(Sort.Direction.DESC, "colName"))
    }

    public List<Veiculo> listarVeiculosMarca(String marca){
        Optional<List<Veiculo>> veiculos = null;
        try {
            veiculos = Optional.ofNullable(veiculoRepository.listarVeiculosMarca(marca));
            return veiculos.get();
        } catch (NoSuchElementException noSuchElementException) {
            return veiculos.orElseThrow(() -> new ResourceNotFoundException(marca));
        }
    }

    public List<Veiculo> listarVeiculosModelo(String modelo){
        Optional<List<Veiculo>> veiculos = null;
        try {
            veiculos = Optional.ofNullable(veiculoRepository.listarVeiculosModelo(modelo));
            return veiculos.get();
        } catch (NoSuchElementException noSuchElementException) {
            return veiculos.orElseThrow(() -> new ResourceNotFoundException(modelo));
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

    public List<Veiculo> listarVeiculosEstadoConservacao(String estadoConservacao) {
        Optional<List<Veiculo>> veiculos = null;
        try {
            veiculos = Optional.ofNullable(veiculoRepository.listarVeiculosEstadoConservacao(estadoConservacao));
            return veiculos.get();
        } catch (NoSuchElementException noSuchElementException) {
            return veiculos.orElseThrow(() -> new ResourceNotFoundException(estadoConservacao));
        }
    }

    public List<Veiculo> listarVeiculosIntervaloKmRodados(int kmInicial, int kmFinal) {
        Optional<List<Veiculo>> veiculos = null;
        try {
            veiculos = Optional.ofNullable(veiculoRepository.listarVeiculosIntervaloKmRodados(kmInicial, kmFinal));
            return veiculos.get();
        } catch (NoSuchElementException noSuchElementException) {
            return veiculos.orElseThrow(() -> new ResourceNotFoundException(kmFinal));
        }
    }

    public List<OrdemTrafego> listarOrdensTrafegoVeiculo(Integer id) {
        Optional<List<OrdemTrafego>> ordensTrafego = null;
        try {
            ordensTrafego = Optional.ofNullable(ordemTrafegoRepository.listarOrdensTrafegoVeiculo(id));
            return ordensTrafego.get();
        } catch (NoSuchElementException noSuchElementException) {
            return ordensTrafego.orElseThrow(() -> new ResourceNotFoundException(id));
        }
    }
}
