package com.ordemtrafego.controller;

import com.ordemtrafego.domain.Condutor;
import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.domain.Veiculo;
import com.ordemtrafego.repository.CondutorRepository;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import com.ordemtrafego.repository.VeiculoRepository;
import com.ordemtrafego.service.OrdemTrafegoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Ordem de táfego")
@CrossOrigin(origins = "*")
public class OrdemTrafegoController {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    private OrdemTrafegoService ordemTrafegoService;

    @Autowired
    OrdemTrafegoRepository ordemTrafegoRepository;

    @Autowired
    CondutorRepository condutorRepository;

    @Autowired
    VeiculoRepository veiculoRepository;




    @PostMapping("/ordemTrafego/inserirOrdemTrafego/{idCondutor}/{idVeiculo}")
    @ApiOperation(value = "Inserir ordem de tráfego.")
    public ResponseEntity<OrdemTrafego> inserirOrdemTrafego(@RequestBody OrdemTrafego ordemTrafego, @PathVariable("idCondutor") Integer idCondutor, @PathVariable("idVeiculo") Integer idVeiculo) throws ParseException {

        /*DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = (Date)formatter.parse(ordemTrafego.getData().toString());
        ordemTrafego.setData(date);*/

        Condutor condutor = ordemTrafegoService.buscarCondutorId(idCondutor);
        ordemTrafego.setCondutor(condutor);
        Veiculo veiculo = ordemTrafegoService.buscarVeiculoId(idVeiculo);
        ordemTrafego.setVeiculo(veiculo);
        ordemTrafegoService.inserirOrdemTrafego(ordemTrafego);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemTrafego.getId()).toUri();
        return ResponseEntity.created(uri).body(ordemTrafego);
    }

    @PutMapping("/ordemTrafego/atualizarOrdemTrafego/{idCondutor}/{idVeiculo}")
    @ApiOperation(value = "Atualizar uma ordem de tráfego.")
    public ResponseEntity<OrdemTrafego> atualizarOrdemTrafego(
            @RequestBody OrdemTrafego ordemTrafego,
            @PathVariable("idCondutor") Integer idCondutor,
            @PathVariable("idVeiculo") Integer idVeiculo) {

        Condutor condutor = ordemTrafegoService.buscarCondutorId(idCondutor);
        ordemTrafego.setCondutor(condutor);
        Veiculo veiculo = ordemTrafegoService.buscarVeiculoId(idVeiculo);
        ordemTrafego.setVeiculo(veiculo);
        ordemTrafegoService.atualizarOrdemTrafego(ordemTrafego);
        return ResponseEntity.ok().body(ordemTrafego);
    }

    @DeleteMapping("/ordemTrafego/deletarOrdemTrafego/{id}")
    @ApiOperation(value = "Deletar ordem de tráfego passando o id.")
    public ResponseEntity<String> deletarOrdemTrafego(@PathVariable(value = "id") Integer id) {
        ordemTrafegoService.deletarOrdemTrafego(id);
        return ResponseEntity.ok().body("Ordem de tráfego excluida");
    }

    @GetMapping("/ordemTrafego/ordensTrafego")
    @ApiOperation(value = "Listar todas ordens de tráfego.")
    public ResponseEntity<List<OrdemTrafego>> listarOrdensTrafego() {
        List<OrdemTrafego> ordensTrafego = ordemTrafegoService.listarOrdensTrafego();
        return ResponseEntity.ok().body(ordensTrafego);
    }

    @GetMapping("/ordemTrafego/listarOrdensTrafegoData/{dataInicial}/{dataFinal}")
    @ApiOperation(value = "Listar ordens de tráfego por data.")
    public ResponseEntity<List<OrdemTrafego>> listarOrdensTrafegoData(
            @PathVariable(value = "dataInicial") String dataInicial,
            @PathVariable(value = "dataFinal") String dataFinal) throws ParseException {
        List<OrdemTrafego> ordensTrafego = ordemTrafegoService.listarOrdensTrafegoData(format.parse(dataInicial), format.parse(dataFinal));
        return ResponseEntity.ok().body(ordensTrafego);
    }

    @GetMapping("/ordemTrafego/buscarOrdemTrafegoOrigem/{cidadeOrigem}")
    @ApiOperation(value = "Listar ordens de tráfego por cidade de origem.")
    public ResponseEntity<List<OrdemTrafego>> listarOrdensTrafegoCidadeOrigem(@PathVariable(value = "cidadeOrigem") String cidadeOrigem) {
        List<OrdemTrafego> ordensTrafego = ordemTrafegoService.listarOrdensTrafegoCidadeOrigem(cidadeOrigem);
        return ResponseEntity.ok().body(ordensTrafego);
    }

    @GetMapping("/ordemTrafego/buscarOrdemTrafegoDestino/{cidadeDestino}")
    @ApiOperation(value = "Listar ordens de tráfego por destino.")
    public ResponseEntity<List<OrdemTrafego>> listarOrdemTrafegoCidadeDestino(@PathVariable(value = "cidadeDestino") String cidadeDestino) {
        List<OrdemTrafego> ordensTrafego = ordemTrafegoService.listarOrdensTrafegoCidadeDestino(cidadeDestino);
        return ResponseEntity.ok().body(ordensTrafego);
    }

    @GetMapping("/ordemTrafego/buscarOrdensStatus/{status}")
    @ApiOperation(value = "Listar ordens de tráfego por status.")
    public ResponseEntity<List<OrdemTrafego>> listarOrdemTrafegoStatus(@PathVariable(value = "status") String status) {
        List<OrdemTrafego> ordensTrafego = ordemTrafegoService.listarOrdemTrafegoStatus(status);
        return ResponseEntity.ok().body(ordensTrafego);
    }
}
