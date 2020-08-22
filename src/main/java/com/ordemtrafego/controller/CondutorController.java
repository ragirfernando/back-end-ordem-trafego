package com.ordemtrafego.controller;

import com.ordemtrafego.domain.Cnh;
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
import java.text.ParseException;
import java.util.List;
import java.util.Random;

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
        condutor.setMatricula(gerarMatricula());
        condutor = condutorService.inserirCondutor(condutor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(condutor.getId()).toUri();
        return ResponseEntity.created(uri).body(condutor);
    }

    public String gerarMatricula(){
        Random  random = new Random();
        int numeroMatricula = 0;
        List<Condutor> condutores;
        numeroMatricula = random.nextInt(999999999);
        condutores = condutorService.listarCondutores();
        String finalNumeroMatricula = String.valueOf(numeroMatricula);
        condutores.forEach(condutor -> {
            if (condutor.getMatricula().equals(finalNumeroMatricula)){
                gerarMatricula();
            }
        });
        return finalNumeroMatricula;
    }

    @DeleteMapping("/condutor/deletarCondutorId/{id}")
    @ApiOperation(value = "Deletar condutor por Id.")
    public String deletarCondutor(@PathVariable Integer id) {
        return condutorService.deletarCondutor(id);
    }

    @PutMapping("/condutor/atualizarCondutor")
    @ApiOperation(value = "Atualizar um condutor.")
    public ResponseEntity<Condutor> atualizarCondutor(@RequestBody Condutor condutor) {
        condutor = condutorService.atualizarCondutor(condutor);
        return ResponseEntity.ok().body(condutor);
    }

    @GetMapping("/condutor/listarCondutoresCategoriaCnh/{categoriaCnh}")
    @ApiOperation(value = "Buscar condutor por categoria da CNH.")
    public ResponseEntity<List<Condutor>> listarCondutoresCategoriaCnh(@PathVariable(value = "categoriaCnh") String categoriaCnh) {
        List<Condutor> condutores = condutorService.listarCondutoresCategoriaCnh(categoriaCnh);
        return ResponseEntity.ok().body(condutores);
    }

    @GetMapping("/condutor/listarCondutorNumeroCnh/{numeroCnh}")
    @ApiOperation(value = "Buscar condutor por numero da CNH.")
    public ResponseEntity<Condutor> listarCondutorNumeroCnh(@PathVariable(value = "numeroCnh") Integer numeroCnh) {
        Condutor condutor = condutorService.listarCondutorNumeroCnh(numeroCnh);
        return ResponseEntity.ok().body(condutor);
    }

    @GetMapping("/condutor/buscarCondutorNome/{nome}")
    @ApiOperation(value = "Buscar um condutor por nome.")
    public ResponseEntity<List<Condutor>> buscaCondutorNome(@PathVariable(value = "nome") String nome) {
        System.out.println(nome);
        List<Condutor> condutores = condutorService.buscaCondutorNome(nome);
        return ResponseEntity.ok().body(condutores);
    }

    @GetMapping("/condutor/listarOrdensTrafegoCondutor/{id}")
    @ApiOperation(value = "Listar todas as ordens de tráfego que esta relacionada com o condutor, passando o id do condutor.")
    public ResponseEntity<List<OrdemTrafego>> listarOrdensTrafegoCondutor(@PathVariable("id") Integer id) {
        List<OrdemTrafego> ordensTrafego = condutorService.listarOrdensTrafegoCondutor(id);
        return ResponseEntity.ok().body(ordensTrafego);
    }
}
