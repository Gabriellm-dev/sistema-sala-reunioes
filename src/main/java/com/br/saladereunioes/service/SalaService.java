package com.br.saladereunioes.service;

import com.br.saladereunioes.model.Sala;
import com.br.saladereunioes.repository.SalaRepository;

public class SalaService {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public void addSala(Sala sala) {
        if (sala == null) {
            throw new IllegalArgumentException("Sala não pode ser nula.");
        }
        salaRepository.addSala(sala);
    }

    public void updateSala(Sala sala) {
        if (sala == null || sala.getId() == null) {
            throw new IllegalArgumentException("Sala e ID não podem ser nulos.");
        }
        salaRepository.updateSala(sala);
    }

    public void deleteSala(Object id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        salaRepository.deleteSala(id);
    }

    public Sala getSala(Object id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        return salaRepository.getSala(id);
    }

    public void deleteAll() {
        salaRepository.deleteAll();
    }

    public void updateStatus(Object id, String status, Integer capacidade, String[] recursos, String nome) {
        if (id == null || status == null) {
            throw new IllegalArgumentException("ID e status não podem ser nulos.");
        }
        salaRepository.updateStatus(id, status, capacidade, recursos, nome);
    }
}
