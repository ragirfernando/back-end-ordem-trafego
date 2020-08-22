package com.ordemtrafego.repository;

import com.ordemtrafego.domain.OrdemTrafego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface OrdemTrafegoRepository extends JpaRepository<OrdemTrafego, Integer> {
    @Query(value = "select *from ordem_trafego where veiculo_id = ?1", nativeQuery = true)
    List<OrdemTrafego> listarOrdensTrafegoVeiculo(Integer idVeiculo);

    @Query(value = "select *from ordem_trafego where condutor_id = ?1",
            nativeQuery = true)
    List<OrdemTrafego> listarOrdensTrafegoCondutor(Integer idCondutor);

    @Query(value = "select *from ordem_trafego where data BETWEEN  ?1 and  ?2",nativeQuery = true)
    List<OrdemTrafego> listarOrdensTrafegoData(Date dataInicial, Date dataFinal);

    @Query(value = "SELECT *FROM ordem_trafego as ot" +
            "    INNER JOIN endereco des on ot.destino_id = des.id" +
            "    INNER JOIN endereco ori on ot.origem_id = ori.id" +
            "    INNER JOIN condutor con on ot.condutor_id = con.id" +
            "    INNER JOIN veiculo vei on ot.veiculo_id = vei.id" +
            "    where ori.localidade like %?1%",
            nativeQuery = true)
    List<OrdemTrafego> listarOrdensTrafegoCidadeOrigem(String cidadeOrigem);

    @Query(value = "SELECT *FROM ordem_trafego as ot\n" +
            "    INNER JOIN endereco des on ot.destino_id = des.id\n" +
            "    INNER JOIN endereco ori on ot.origem_id = ori.id\n" +
            "    INNER JOIN condutor con on ot.condutor_id = con.id\n" +
            "    INNER JOIN veiculo vei on ot.veiculo_id = vei.id\n" +
            "    where des.localidade like %?1%",
            nativeQuery = true)
    List<OrdemTrafego> listarOrdensTrafegoCidadeDestino(String destino);

    @Query(value = "select *from ordem_trafego where status like %?1%", nativeQuery = true)
    List<OrdemTrafego> listarOrdemTrafegoStatus(String status);



}
