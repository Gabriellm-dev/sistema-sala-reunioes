package com.br.saladereunioes;

import com.br.saladereunioes.controller.SalaController;
import com.br.saladereunioes.repository.SalaRepository;
import com.br.saladereunioes.service.SalaService;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        
        MongoDatabase database = MongoClients.create("mongodb://localhost:27017").getDatabase("salareuniaodb");

        
        SalaRepository salaRepository = new SalaRepository(database);
        SalaService salaService = new SalaService(salaRepository);

        
        SalaController salaController = new SalaController(salaService);

        // Testando uma sala
        salaController.createSala("Sala de Reunião A", 10, new String[]{"TV", "Conferência"}, "Disponível");
    }
}
