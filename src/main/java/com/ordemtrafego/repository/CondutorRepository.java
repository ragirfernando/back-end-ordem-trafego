package com.ordemtrafego.repository;

import com.ordemtrafego.domain.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Integer> {

    @Query(value = "select *from condutor where id = ?1", nativeQuery = true)
    Condutor buscaCondutor(Integer id);

    @Query(value = "SELECT *FROM condutor as con" +
            "        INNER JOIN endereco ende on con.endereco_id = ende.id" +
            "        INNER JOIN cnh c on con.cnh_id = c.id" +
            "        where c.categoriacnh = ?1", nativeQuery = true)
    List<Condutor> buscaCondutorCategoriaCnh(String categoriaCnh);

    @Query(value = "SELECT *FROM condutor as con" +
            "        INNER JOIN endereco ende on con.endereco_id = ende.id" +
            "        INNER JOIN cnh c on con.cnh_id = c.id" +
            "        where con.nome = ?1", nativeQuery = true)
    Condutor buscaCondutorNome(String nome);

}
