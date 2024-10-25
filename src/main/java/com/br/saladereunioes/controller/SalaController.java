package com.br.saladereunioes.controller;

import org.bson.types.ObjectId;
import com.br.saladereunioes.model.Sala;
import com.br.saladereunioes.service.SalaService;

public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    public void createSala(String nome, int capacidade, String[] recursos, String status) {
        if (nome == null || nome.isEmpty() || status == null || status.isEmpty()) {
            System.out.println("Erro: Nome e status são obrigatórios.");
            return;
        }
        try {
            Sala sala = new Sala(nome, capacidade, recursos, status);
            salaService.addSala(sala);
            System.out.println("Sala '" + nome + "' criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar a sala: " + e.getMessage());
        }
    }

    public void updateSala(ObjectId id, String nome, int capacidade, String[] recursos, String status) {
        if (id == null) {
            System.out.println("Erro: ID da sala é obrigatório para atualização.");
            return;
        }
        try {
            Sala sala = new Sala(nome, capacidade, recursos, status);
            sala.setId(id);
            salaService.updateSala(sala);
            System.out.println("Sala com ID " + id + " atualizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a sala: " + e.getMessage());
        }
    }

    public void deleteSala(String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("Erro: ID da sala é obrigatório para exclusão.");
            return;
        }
        try {
            salaService.deleteSala(id);
            System.out.println("Sala com ID " + id + " deletada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar a sala: " + e.getMessage());
        }
    }

    public void getSala(String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("Erro: ID da sala é obrigatório para busca.");
            return;
        }
        try {
            Sala sala = salaService.getSala(id);
            if (sala == null) {
                System.out.println("Sala não encontrada.");
            } else {
                System.out.println("Sala encontrada: " +
                        "\nNome: " + sala.getNome() +
                        "\nCapacidade: " + sala.getCapacidade() +
                        "\nRecursos: " + String.join(", ", sala.getRecursos()) +
                        "\nStatus: " + sala.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar a sala: " + e.getMessage());
        }
    }

    public void deleteAll() {
        try {
            salaService.deleteAll();
            System.out.println("Todas as salas foram deletadas.");
        } catch (Exception e) {
            System.out.println("Erro ao deletar todas as salas: " + e.getMessage());
        }
    }

    public void updateStatus(String id, String status, Integer capacidade, String[] recursos, String nome) {
        if (id == null || id.isEmpty() || status == null || status.isEmpty()) {
            System.out.println("Erro: ID e status são obrigatórios para atualização.");
            return;
        }
        try {
            salaService.updateStatus(id, status, capacidade, recursos, nome);
            System.out.println("Status da sala com ID " + id + " atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o status da sala: " + e.getMessage());
        }
    }
}
