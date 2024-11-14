package com.br.saladereunioes.service;

import com.br.saladereunioes.model.Reserva;
import com.br.saladereunioes.model.Sala;
import com.br.saladereunioes.repository.ReservaRepository;
import com.br.saladereunioes.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, SalaRepository salaRepository) {
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
    }

    public ResponseEntity<Reserva> addReserva(Reserva reserva) {
        Sala sala = salaRepository.findById(reserva.getSalaId())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        if (!sala.isAtiva()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        boolean conflito = reservaRepository.existsBySalaIdAndDataInicioLessThanEqualAndDataFimGreaterThanEqual(
                reserva.getSalaId(),
                reserva.getDataFim(),
                reserva.getDataInicio()
        );

        if (conflito) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        reservaRepository.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    public List<Reserva> findReservasByUsuario(String usuario) {
        return reservaRepository.findByUsuario(usuario);
    }
}
