package com.br.saladereunioes.repository;

import com.br.saladereunioes.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
    List<Reserva> findBySalaId(String salaId);
    List<Reserva> findByUsuario(String usuario);

    boolean existsBySalaIdAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(String salaId, Date dataFim, Date dataInicio);
}
