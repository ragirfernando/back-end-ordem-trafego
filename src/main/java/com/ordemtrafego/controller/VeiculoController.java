package com.ordemtrafego.controller;

import com.ordemtrafego.domain.OrdemTrafego;
import com.ordemtrafego.domain.Veiculo;
import com.ordemtrafego.error.ResourceNorFoundExcepition;
import com.ordemtrafego.repository.OrdemTrafegoRepository;
import com.ordemtrafego.repository.VeiculoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Ordem de táfego")
@CrossOrigin(origins = "*")
public class VeiculoController {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    OrdemTrafegoRepository ordemTrafegoRepository;
    List<Veiculo> veiculos;

    @PostMapping("/veiculo/salvarVeiculo")
    @ApiOperation(value = "Salva um veículo.")
    public Veiculo salvarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @PutMapping("/veiculo/editarVeiculo")
    @ApiOperation(value = "Editar veículo.")
    public Veiculo editarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @DeleteMapping("/veiculo/deletarVeiculo")
    @ApiOperation(value = "Deletar veículo por Id.")
    public String deletarVeiculoPorId(@RequestBody Veiculo veiculo){
        Integer id = veiculo.getId();
        veiculoRepository.deleteById(id);
        return "Veiculo excluido";
    }

    @GetMapping("/veiculo/veiculos")
    @ApiOperation(value = "Lista todos os veículos.")
    public List<Veiculo> listarVeiculos() {
        veiculos = veiculoRepository.listaVeiculos();
        if (veiculos.isEmpty()){
            throw new  ResourceNorFoundExcepition("Não tem veículo cadastrado");
        }
        return veiculos;
    }

    @GetMapping("/veiculo/buscarVeiculoMarca/{marca}")
    @ApiOperation(value = "lista veículos por marca.")
    public List<Veiculo> buscarVeliculoMarca(@PathVariable(value = "marca") String marca) {
        return veiculoRepository.buscarVeiculoMarca(marca);
    }

    @GetMapping("/veiculo/buscarVeiculoId/{id}")
    @ApiOperation(value = "Lista um veículo por Id.")
    public Veiculo buscarVeliculoId(@PathVariable(value = "id") Integer id) {
        return veiculoRepository.buscarVeiculo(id);
    }

    @GetMapping("/veiculo/buscarVeiculoModelo/{modelo}")
    @ApiOperation(value = "Lista veículos por modelo.")
    public List<Veiculo> buscarVeiculoModelo(@PathVariable(value = "modelo") String modelo) {
        return veiculoRepository.buscarVeiculoModelo(modelo);
    }

    @GetMapping("/veiculo/buscarVeiculoeEstadoConservacao/{estadoConservacao}")
    @ApiOperation(value = "Lista veículos por estado de conservação.")
    public List<Veiculo> buscarVeiculoEstadoConservacao(@PathVariable(value = "estadoConservacao") String estadoConservacao) {
        return veiculoRepository.buscarVeiculoeEtadoConservacao(estadoConservacao);
    }

    @GetMapping("/veiculo/buscarVeiculoIntervaloKm/{inicial}/{final}")
    @ApiOperation(value = "Lista veículos por intervalo de km rodados, passando dois valores.")
    public List<Veiculo> buscarVeiculoIntervaloKm(@PathVariable("inicial") String inicial, @PathVariable("final") String fim)  {
        return veiculoRepository.buscarVeiculoIntervaloKm(Integer.valueOf(inicial), Integer.valueOf(fim));
    }

    @GetMapping("/veiculo/buscarOrdemTrafegoVeiculo/{idVeiculo}")
    @ApiOperation(value = "Lista ordens de tráfego no qual o veiculo esta vinculado, passando o Id do veículo.")
    public List<OrdemTrafego> buscarOrdemTrafegoVeiculo(@PathVariable("idVeiculo") String idVeiculo)  {
        return ordemTrafegoRepository.buscarOrdemTrafegoVeiculo (Integer.valueOf(idVeiculo));
    }
}
