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
    List<Condutor> listarCondutoresCategoriaCnh(String categoriaCnh);

    @Query(value = "SELECT *FROM condutor as con\n" +
            "       INNER JOIN endereco ende on con.endereco_id = ende.id\n" +
            "       INNER JOIN cnh c on con.cnh_id = c.id\n" +
            "       where c.numerocnh  = ?1", nativeQuery = true)
    Condutor listarCondutorNumeroCnh(Integer numeroCnh);

    @Query(value = "SELECT *FROM condutor where nome like %?1%", nativeQuery = true)
    List<Condutor> buscaCondutorNome(String nome);

}
