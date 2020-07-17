package com.ordemtrafego.controller;

import com.ordemtrafego.domain.Condutor;
import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.domain.Veiculo;
import com.ordemtrafego.repository.CondutorRepository;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import com.ordemtrafego.repository.VeiculoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Ordem de táfego")
@CrossOrigin(origins = "*")
public class OrdemTrafegoController {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Autowired
    OrdemTrafegoRepository ordemTrafegoRepository;

    @Autowired
    CondutorRepository condutorRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    @PostMapping("/ordemTrefego/salvarOrdemTrafego/{idCondutor}/{idVeiculo}")
    @ApiOperation(value = "Salva uma ordem de tráfego.")
    public OrdemTrafego salvarOrdemTrafego(
            @RequestBody OrdemTrafego ordemTrafego, @PathVariable("idCondutor") Integer idCondutor, @PathVariable("idVeiculo") Integer idVeiculo) {
        Condutor condutor = condutorRepository.buscaCondutor(idCondutor);
        ordemTrafego.setCondutor(condutor);
        Veiculo veiculo = veiculoRepository.buscarVeiculo(idVeiculo);
        ordemTrafego.setVeiculo(veiculo);
        return ordemTrafegoRepository.save(ordemTrafego);
    }

    @PutMapping("/ordemTrefego/editarOrdemTrafego/{idCondutor}/{idVeiculo}")
    @ApiOperation(value = "Editar uma ordem de tráfego.")
    public OrdemTrafego editarOrdemTrafego(
            @RequestBody OrdemTrafego ordemTrafego, @PathVariable("idCondutor")
            Integer idCondutor, @PathVariable("idVeiculo") Integer idVeiculo) {
        Condutor condutor = condutorRepository.buscaCondutor(idCondutor);
        ordemTrafego.setCondutor(condutor);
        Veiculo veiculo = veiculoRepository.buscarVeiculo(idVeiculo);
        ordemTrafego.setVeiculo(veiculo);
        return ordemTrafegoRepository.save(ordemTrafego);
    }

    @DeleteMapping("/ordemTrefego/deletarOrdemTrafego/{id}")
    @ApiOperation(value = "Deletar uma ordem de tráfego.")
    public void deletarOrdemTrafego(@PathVariable(value = "id") Integer id) {
        ordemTrafegoRepository.deleteById(id);
    }

    @GetMapping("/ordemTrefego/ordensTrafego")
    @ApiOperation(value = "Listar todas ordens de tráfego.")
    public List<OrdemTrafego> listaOrdensTrafego() {
        return ordemTrafegoRepository.findAll();
    }

    @GetMapping("/ordemTrefego/buscarOrdemTrafegoData/{data}")
    @ApiOperation(value = "Listar ordens de tráfego por data.")
    public List<OrdemTrafego> buscarOrdemTrafegoData(@PathVariable(value = "data") String data) {
        LocalDate localDate = LocalDate.parse(data, formatter);
        return ordemTrafegoRepository.buscarOrdemTrafegoData(localDate);
    }

    @GetMapping("/ordemTrefego/buscarOrdemTrafegoOrigem/{origem}")
    @ApiOperation(value = "Listar ordens de tráfego por origem.")
    public List<OrdemTrafego> buscarOrdemTrafegoOrigem(@PathVariable(value = "origem") String origem) {
        return ordemTrafegoRepository.buscarOrdemTrafegoOrigem(origem);
    }

    @GetMapping("/ordemTrefego/buscarOrdemTrafegoDestino/{destino}")
    @ApiOperation(value = "Listar ordens de tráfego por destino.")
    public List<OrdemTrafego> buscarOrdemTrafegoDestino(@PathVariable(value = "destino") String destino) {
        return ordemTrafegoRepository.buscarOrdemTrafegoDestino(destino);
    }


}
