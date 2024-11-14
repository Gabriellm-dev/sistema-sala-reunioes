package com.br.saladereunioes.service;

import com.br.saladereunioes.model.Sala;
import com.br.saladereunioes.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public Sala addSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public Sala getSalaById(String id) {
        return salaRepository.findById(id).orElse(null);
    }

    public void updateSala(Sala sala) {
        salaRepository.save(sala);
    }

    public void deleteSala(String id) {
        salaRepository.deleteById(id);
    }

    public List<Sala> buscarSalasDisponiveis(Integer capacidade, List<String> recursos, LocalDate data) {
        if (recursos != null && !recursos.isEmpty()) {
            return salaRepository.findByCapacidadeGreaterThanEqualAndAtivaTrueAndNomeIn(capacidade, recursos);
        }
        return salaRepository.findByCapacidadeGreaterThanEqualAndAtivaTrue(capacidade);
    }

    public List<Sala> getTodasSalas() {
        return salaRepository.findAll();
    }
}
