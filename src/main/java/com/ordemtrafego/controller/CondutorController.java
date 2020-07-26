package com.ordemtrafego.controller;

import com.ordemtrafego.domain.Condutor;
import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.repository.CondutorRepository;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Ordem de tráfego")
@CrossOrigin(origins = "*")
public class CondutorController {

    @Autowired
    CondutorRepository condutorRepository;

    @Autowired
    OrdemTrafegoRepository ordemTrafegoRepository;

    List<Condutor> condutores = new ArrayList<>();

    @PostMapping("/condutor/inserirCondutor")
    @ApiOperation(value = "Inserir um condutor.")
    public Condutor inserirCondutor(@RequestBody Condutor condutor) {
        try {
            return condutorRepository.save(condutor);
        } catch (Exception exception) {
            return condutor = new Condutor();
        }
    }

    @PutMapping("/condutor/editarCondutor")
    @ApiOperation(value = "Editar um condutor.")
    public Condutor editarCondutor(@RequestBody Condutor condutor) {
        System.out.println(condutor);

        return condutorRepository.save(condutor);
    }

    @DeleteMapping("/condutor/deletarCondutor")
    @ApiOperation(value = "Deletar condutor por Id.")
    public Condutor deletarCondutor(@RequestBody Condutor condutor) {
        condutorRepository.delete(condutor);
        return condutor;
    }

    @GetMapping("/condutor/condutores")
    @ApiOperation(value = "Lista todos os condutores.")
    public ResponseEntity<List<Condutor>> listarCondutores() {
        List<Condutor> condutores = new ArrayList<>();
        try {
            condutores = condutorRepository.findAll();
            return ResponseEntity.ok().body(condutores); //<>(condutores, HttpStatus.OK);
        } catch (Exception exception) {
            return ResponseEntity.of(Optional.ofNullable(condutores));
        }
    }

    @GetMapping("/condutor/buscarCondutorCategoriaCnh/{categoriaCnh}")
    @ApiOperation(value = "Buscar condutor por categoria da CNH.")
    public List<Condutor> buscarCondutorCategoriaCnh(@PathVariable(value = "categoriaCnh") String categoriaCnh) {
        condutores = condutorRepository.buscaCondutorCategoriaCnh(categoriaCnh);
        return condutores;
    }

    @GetMapping("/condutor/buscarCondutorNome/{nome}")
    @ApiOperation(value = "Buscar um condutor por nome.")
    public Condutor buscaCondutorNome(@PathVariable(value = "nome") String nome) {
        return condutorRepository.buscaCondutorNome(nome);
    }

    @GetMapping("/condutor/buscarOrdemTrafegoVeiculo/{idCondutor}")
    @ApiOperation(value = "Buscar todas as ordens de tráfego que esta relacionada com o condutor, passando o id do condutor.")
    public List<OrdemTrafego> buscarOrdemTrafegoVeiculo(@PathVariable("idCondutor") String idCondutor) {
        return ordemTrafegoRepository.buscarOrdemTrafegoCondutor(Integer.valueOf(idCondutor));
    }
}
