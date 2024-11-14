package com.br.saladereunioes.controller;

import com.br.saladereunioes.model.Sala;
import com.br.saladereunioes.service.SalaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {
    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping
    public ResponseEntity<Sala> addSala(@RequestBody Sala sala) {
        sala.setAtiva(true);
        Sala novaSala = salaService.addSala(sala);
        return ResponseEntity.ok(novaSala);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable String id) {
        Sala sala = salaService.getSalaById(id);
        if (sala == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSala(@PathVariable String id, @RequestBody Sala sala) {
        Sala salaExistente = salaService.getSalaById(id);
        if (salaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        sala.setId(salaExistente.getId());
        salaService.updateSala(sala);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable String id) {
        Sala salaExistente = salaService.getSalaById(id);
        if (salaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        salaService.deleteSala(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Sala>> buscarSalasDisponiveis(
            @RequestParam(value = "capacidade", required = false) Integer capacidade,
            @RequestParam(value = "recursos", required = false) List<String> recursos,
            @RequestParam(value = "data", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        List<Sala> salasDisponiveis = salaService.buscarSalasDisponiveis(capacidade, recursos, data);
        return ResponseEntity.ok(salasDisponiveis);
    }
    
    @GetMapping
    public ResponseEntity<List<Sala>> getTodasSalas() {
        List<Sala> todasSalas = salaService.getTodasSalas();
        return ResponseEntity.ok(todasSalas);
    }
}
