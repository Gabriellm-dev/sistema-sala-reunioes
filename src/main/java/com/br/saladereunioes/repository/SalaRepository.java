package com.br.saladereunioes.repository;

import com.br.saladereunioes.model.Sala;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SalaRepository extends MongoRepository<Sala, String> {

    List<Sala> findByCapacidadeGreaterThanEqualAndAtivaTrue(int capacidade);
    List<Sala> findByCapacidadeGreaterThanEqualAndAtivaTrueAndNomeIn(int capacidade, List<String> recursos);
    List<Sala> findAll();
}
