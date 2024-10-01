package com.example.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.example.model.Professor;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

public class ProfessorDAO {

    private MongoDatabase database;

    public ProfessorDAO() {
        // criando a conexão
        this.database = ConnectionFactory.getDatabase();
    }

    // criando um objeto para inserir no mongo
    public void cadastrarProfessor(Professor professor) {
        MongoCollection<Document> collection = database.getCollection("professores");
        Document doc = new Document("nome", professor.getNome())
                .append("email", professor.getEmail())
                .append("telefone", professor.getTelefone())
                .append("registroFaculdade", professor.getRegistroFaculdade())
                .append("nomeFaculdade", professor.getNomeFaculdade())
                .append("formacao", professor.getFormacao())
                .append("idade", professor.getIdade())
                .append("senha", professor.getSenha())
                .append("linkedinGithub", professor.getLinkedinGithub())
                .append("areaDeEstudo", professor.getAreaDeEstudo())
                .append("alunos", professor.getAlunos());
        collection.insertOne(doc);
    }

    public Professor buscarProfessorPorEmailESenha(String email, String senha) {
        MongoCollection<Document> collection = database.getCollection("professores");
        Document result = collection.find(eq("email", email)).first();

        if (result != null && result.getString("senha").equals(senha)) {
            return new Professor(
                    result.getString("nome"),
                    result.getString("email"),
                    result.getString("telefone"),
                    result.getString("registroFaculdade"),
                    result.getString("nomeFaculdade"),
                    result.getString("formacao"),
                    result.getString("idade"),
                    result.getString("senha"),
                    result.getString("linkedinGithub"),
                    result.getString("areaDeEstudo"));
        }
        return null;
    }
}
