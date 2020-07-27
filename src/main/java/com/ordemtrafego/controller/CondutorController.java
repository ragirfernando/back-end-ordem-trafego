package com.ordemtrafego.controller;

import com.ordemtrafego.domain.Condutor;
import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.service.CondutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Ordem de tráfego")
@CrossOrigin(origins = "*")
public class CondutorController {

    @Autowired
    private CondutorService condutorService;

    @GetMapping("/condutor/condutores")
    @ApiOperation(value = "Lista todos os condutores.")
    public ResponseEntity<List<Condutor>> listarCondutores() {
        List<Condutor> condutores = condutorService.listarCondutores();
        return ResponseEntity.ok().body(condutores);
    }

    @GetMapping("/condutor/buscarCondutorId/{id}")
    @ApiOperation(value = "Buscar condutor por id.")
    public ResponseEntity<Condutor> buscarCondutorId(@PathVariable(value = "id") Integer id) {
        Condutor condutor = condutorService.buscarCondutorId(id);
        return ResponseEntity.ok().body(condutor);
    }


    @PostMapping("/condutor/inserirCondutor")
    @ApiOperation(value = "Inserir um condutor.")
    public ResponseEntity<Condutor> inserirCondutor(@RequestBody Condutor condutor) {
        condutor = condutorService.inserirCondutor(condutor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(condutor.getId()).toUri();
        return ResponseEntity.created(uri).body(condutor);
    }

    @DeleteMapping("/condutor/deletarCondutorId/{id}")
    @ApiOperation(value = "Deletar condutor por Id.")
    public ResponseEntity<Void> deletarCondutor(@PathVariable Integer id) {
        condutorService.deletarCondutor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/condutor/atualizarCondutor")
    @ApiOperation(value = "Atualizar um condutor.")
    public ResponseEntity<Condutor> atualizarCondutor(@RequestBody Condutor condutor) {
        condutor = condutorService.atualizarCondutor(condutor);
        return ResponseEntity.ok().body(condutor);
    }

    @GetMapping("/condutor/listarCondutoresCategoriaCnh/{categoriaCnh}")
    @ApiOperation(value = "Buscar condutor por categoria da CNH.")
    public List<Condutor> listarCondutoresCategoriaCnh(@PathVariable(value = "categoriaCnh") String categoriaCnh) {
        return condutorService.listarCondutoresCategoriaCnh(categoriaCnh);
    }

    @GetMapping("/condutor/buscarCondutorNome/{nome}")
    @ApiOperation(value = "Buscar um condutor por nome.")
    public Condutor buscaCondutorNome(@PathVariable(value = "nome") String nome) {
        return condutorService.buscaCondutorNome(nome);
    }

    @GetMapping("/condutor/listarOrdensTrafegoConditor/{id}")
    @ApiOperation(value = "Listar todas as ordens de tráfego que esta relacionada com o condutor, passando o id do condutor.")
    public List<OrdemTrafego> listarOrdensTrafegoVeiculo(@PathVariable("id") Integer id) {
        return condutorService.listarOrdensTrafegoCondutor(id);
    }
}
