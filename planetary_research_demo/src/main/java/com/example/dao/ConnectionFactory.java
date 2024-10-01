package com.example.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionFactory {
    
    private static MongoClient mongoClient;
    private static final String DATABASE_NAME = "research_school";
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    //  fechar a conexão com o MongoDB
    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
