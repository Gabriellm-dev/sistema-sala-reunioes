package com.br.saladereunioes.controller;

import com.br.saladereunioes.model.Reserva;
import com.br.saladereunioes.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> addReserva(@RequestBody Reserva reserva) {
        try {
            ResponseEntity<Reserva> responseEntity = reservaService.addReserva(reserva);
            Reserva novaReserva = responseEntity.getBody();
            return ResponseEntity.ok(novaReserva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<Reserva>> getReservasByUsuario(@PathVariable String usuario) {
        List<Reserva> reservas = reservaService.findReservasByUsuario(usuario);
        return reservas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reservas);
    }
}
