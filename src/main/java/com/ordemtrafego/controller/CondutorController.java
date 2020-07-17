package com.ordemtrafego.controller;

import com.ordemtrafego.domain.Condutor;
import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.repository.CondutorRepository;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Ordem de táfego")
@CrossOrigin(origins = "*")
public class CondutorController {
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    CondutorRepository condutorRepository;

    @Autowired
    OrdemTrafegoRepository ordemTrafegoRepository;

    Condutor condutor = new Condutor();
    List<Condutor> condutores = new ArrayList<>();

    @PostMapping("/condutor/salvarCondutor")
    @ApiOperation(value = "Salva um condutor.")
    public Condutor salvarCondutor(@RequestBody Condutor condutor) {
        System.out.println(condutor);
        return condutorRepository.save(condutor);
    }

    @PutMapping("/condutor/editarCondutor")
    @ApiOperation(value = "Editar um condutor.")
    public Condutor editarCondutor(@RequestBody Condutor condutor) {
        System.out.println(condutor);

        return condutorRepository.save(condutor);
    }

    @DeleteMapping("/condutor/deletarCondutor")
    @ApiOperation(value = "Deletar condutor por Id.")
    public Condutor deletarCondutor(@RequestBody Condutor condutor){
        condutorRepository.delete(condutor);
        return condutor;
    }

    @GetMapping("/condutor/condutores")
    @ApiOperation(value = "Lista todos os condutores.")
    public List<Condutor> listarCondutores(){
        List<Condutor> condutores = condutorRepository.findAll();
        return condutores;
    }

    @GetMapping("/condutor/buscaCondutorCategoriaCnh/{categoriaCnh}")
    @ApiOperation(value = "Buscar condutor por categoria da CNH.")
    public List<Condutor> buscaCondutorCategoriaCnh(@PathVariable(value = "categoriaCnh") String categoriaCnh){
        condutores = condutorRepository.buscaCondutorCategoriaCnh(categoriaCnh);
        return condutores;
    }

    @GetMapping("/condutor/buscaCondutorNome/{nome}")
    @ApiOperation(value = "Buscar um condutor por nome.")
    public Condutor buscaCondutorNome(@PathVariable(value = "nome") String nome){
        return condutorRepository.buscaCondutorNome(nome);
    }

    @GetMapping("/condutor/buscarOrdemTrafegoVeiculo/{idcondutor}")
    @ApiOperation(value = "Buscar um condutor por Id.")
    public List<OrdemTrafego> buscarOrdemTrafegoVeiculo(@PathVariable("idcondutor") String idcondutor)  {
        return ordemTrafegoRepository.buscarOrdemTrafegoCondutor(Integer.valueOf(idcondutor));
    }


}
