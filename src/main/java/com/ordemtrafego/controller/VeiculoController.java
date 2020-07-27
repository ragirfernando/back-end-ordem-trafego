package com.ordemtrafego.controller;

import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.domain.Veiculo;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import com.ordemtrafego.repository.VeiculoRepository;
import com.ordemtrafego.service.VeiculoService;
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
@Api(value = "API REST Ordem de táfego")
@CrossOrigin(origins = "*")
public class VeiculoController {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    OrdemTrafegoRepository ordemTrafegoRepository;
    private List<Veiculo> veiculoList;
    private Veiculo veiculo;

    @PostMapping("/veiculo/inserirVeiculo")
    @ApiOperation(value = "Inserir um veículo.")
    public ResponseEntity<Veiculo> inserirVeiculo(@RequestBody Veiculo veiculo) {
        veiculo = veiculoService.inserirVeiculo(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).body(veiculo);
    }

    @PutMapping("/veiculo/atualizarVeiculo")
    @ApiOperation(value = "Atualizar veículo.")
    public ResponseEntity<Veiculo> atualizarVeiculo(@RequestBody Veiculo veiculo) {
        veiculo = veiculoService.atualizarVeiculo(veiculo);
        return ResponseEntity.ok().body(veiculo);
    }

    @DeleteMapping("/veiculo/deletarVeiculo/{id}")
    @ApiOperation(value = "Deletar veículo por Id.")
    public String deletarVeiculoPorId(@PathVariable Integer id){
        veiculoService.deletarVeiculo(id);
        return "Veiculo excluido";
    }

    @GetMapping("/veiculo/veiculos")
    @ApiOperation(value = "Listar todos os veículos.")
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        return ResponseEntity.ok().body(veiculos);
    }

    @GetMapping("/veiculo/listarVeiculosMarca/{marca}")
    @ApiOperation(value = "listar veículos por marca.")
    public ResponseEntity<List<Veiculo>> listarVeliculosMarca(@PathVariable(value = "marca") String marca) {
        List<Veiculo> veiculos;
        veiculos = veiculoService.listarVeiculosMarca(marca);
        return ResponseEntity.ok().body(veiculos);
    }

    @GetMapping("/veiculo/listarVeiculosModelo/{modelo}")
    @ApiOperation(value = "Lista veículos por modelo.")
    public ResponseEntity<List<Veiculo>> listarVeiculosModelo(@PathVariable(value = "modelo") String modelo) {
        List<Veiculo> veiculos;
        veiculos = veiculoService.listarVeiculosModelo(modelo);
        return ResponseEntity.ok().body(veiculos);
    }


    @GetMapping("/veiculo/buscarVeiculoId/{id}")
    @ApiOperation(value = "Buscar veículo por Id.")
    public ResponseEntity<Veiculo> buscarVeiculoId(@PathVariable(value = "id") Integer id) {
        Veiculo veiculo;
        veiculo = veiculoService.buscarVeiculoId(id);
        return ResponseEntity.ok().body(veiculo);
    }

    @GetMapping("/veiculo/listarVeiculosEstadoConservacao/{estadoConservacao}")
    @ApiOperation(value = "Listar veículos por estado de conservação.")
    public ResponseEntity<List<Veiculo>> listarVeiculosEstadoConservacao(@PathVariable(value = "estadoConservacao") String estadoConservacao) {
        List<Veiculo> veiculos;
        veiculos = veiculoService.listarVeiculosEstadoConservacao(estadoConservacao);
        return ResponseEntity.ok().body(veiculos);
    }

    @GetMapping("/veiculo/listarVeiculosIntervaloKmRodados/{KmInicial}/{kmFinal}")
    @ApiOperation(value = "Lista veículos por intervalo de km rodados, passando dois valores.")
    public ResponseEntity<List<Veiculo>> listarVeiculosIntervaloKmRodados(@PathVariable("KmInicial") Integer KmInicial, @PathVariable("kmFinal") Integer kmFinal)  {
        List<Veiculo> veiculos;
        veiculos = veiculoService.listarVeiculosIntervaloKmRodados(KmInicial, kmFinal);
        return ResponseEntity.ok().body(veiculos);
    }

    @GetMapping("/veiculo/buscarOrdensTrafegoVeiculo/{id}")
    @ApiOperation(value = "Listar todas as ordens de tráfego que esta relacionada com o condutor, passando o id do veículo.")
    public List<OrdemTrafego> buscarOrdemTrafegoVeiculo(@PathVariable("idVeiculo") Integer id)  {
        return ordemTrafegoRepository.buscarOrdemTrafegoVeiculo (Integer.valueOf(id));
    }
}
