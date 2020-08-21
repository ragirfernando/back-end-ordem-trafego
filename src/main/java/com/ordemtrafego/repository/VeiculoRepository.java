package com.ordemtrafego.repository;

import com.ordemtrafego.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    @Query(value = "select *from veiculo where id = ?1", nativeQuery = true) Veiculo buscarVeiculo(Integer id);
    
    @Query(value = "select *from veiculo where marca = ?1",  nativeQuery = true)
    List<Veiculo> listarVeiculosMarca(String marca);

    @Query(value = "select *from veiculo order by id asc ", nativeQuery = true)
    List<Veiculo> listaVeiculos();

    @Query(value = "select *from veiculo where modelo like %?1%", nativeQuery = true)
    List<Veiculo> listarVeiculosModelo(String modelo);

    @Query(value = "select *from veiculo where estado_conservacao = ?1", nativeQuery = true)
    List<Veiculo> listarVeiculosEstadoConservacao(String estadoConservacao);

    @Query(value = "select *from veiculo where km_rodados > ?1  and km_rodados < ?2", nativeQuery = true)
    List<Veiculo> listarVeiculosIntervaloKmRodados(int kmInicial, int kmFinal );


}
