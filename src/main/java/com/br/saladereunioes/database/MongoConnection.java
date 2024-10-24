package com.br.saladereunioes.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    public static MongoDatabase getDatabase(String dbName) {
        MongoClient client = MongoClients.create(CONNECTION_STRING);
        return client.getDatabase(dbName);
    }
}

