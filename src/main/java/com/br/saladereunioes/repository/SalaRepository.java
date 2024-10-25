package com.br.saladereunioes.repository;

import org.bson.Document;
import com.br.saladereunioes.database.MongoConnection;
import com.br.saladereunioes.model.Sala;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.List;

public class SalaRepository {

    private MongoDatabase database;

    public SalaRepository(MongoDatabase database) {
        this.database = database != null ? database : MongoConnection.getDatabase("salareuniaodb");
    }

    private MongoCollection<Document> getCollection() {
        return database.getCollection("salas");
    }

    public void addSala(Sala sala) {
        List<String> recursosList = Arrays.asList(sala.getRecursos());
        Document doc = new Document("nome", sala.getNome())
                .append("capacidade", sala.getCapacidade())
                .append("recursos", recursosList)
                .append("status", sala.getStatus());
        getCollection().insertOne(doc);
    }

    public void updateSala(Sala sala) {
        List<String> recursosList = Arrays.asList(sala.getRecursos());
        Document doc = new Document("nome", sala.getNome())
                .append("capacidade", sala.getCapacidade())
                .append("recursos", recursosList)
                .append("status", sala.getStatus());
        getCollection().updateOne(new Document("_id", sala.getId()), new Document("$set", doc));
    }

    public void deleteSala(Object id) {
        getCollection().deleteOne(new Document("_id", id));
    }

    public Sala getSala(Object id) {
        Document doc = getCollection().find(new Document("_id", id)).first();
        if (doc == null) {
            return null;
        }
        return new Sala(
                doc.getString("nome"),
                doc.getInteger("capacidade"),
                doc.getList("recursos", String.class).toArray(new String[0]),
                doc.getString("status")
        );
    }

    public void deleteAll() {
        getCollection().deleteMany(new Document());
    }

    public void updateStatus(Object id, String status, Integer capacidade, String[] recursos, String nome) {
        Document updates = new Document("status", status);

        if (capacidade != null) {
            updates.append("capacidade", capacidade);
        }
        if (recursos != null) {
            updates.append("recursos", Arrays.asList(recursos));
        }
        if (nome != null) {
            updates.append("nome", nome);
        }

        getCollection().updateOne(new Document("_id", id), new Document("$set", updates));
    }

    public void updateStatus(Sala sala, Integer capacidade, String[] recursos, String nome) {
        updateStatus(sala.getId(), sala.getStatus(), capacidade, recursos, nome);
    }
}
