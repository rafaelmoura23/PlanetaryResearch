package com.example.dao;

import com.example.model.Aluno;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

public class AlunoDAO {

    private MongoDatabase database;

    public AlunoDAO() {
        this.database = ConnectionFactory.getDatabase();
    }

    public void cadastrarAluno(Aluno aluno) {
        MongoCollection<Document> collection = database.getCollection("alunos");
        Document doc = new Document("nome", aluno.getNome())
                .append("email", aluno.getEmail())
                .append("telefone", aluno.getTelefone())
                .append("ra", aluno.getRa())
                .append("nomeFaculdade", aluno.getNomeFaculdade())
                .append("senha", aluno.getSenha())
                .append("curso", aluno.getCurso())
                .append("orientador", aluno.getOrientador())
                .append("linkedinGithub", aluno.getLinkedinGithub())
                .append("areaDePesquisa", aluno.getAreaDePesquisa());
        collection.insertOne(doc);
    }

    public Aluno buscarAlunoPorEmailESenha(String email, String senha) {
        MongoCollection<Document> collection = database.getCollection("alunos");
        Document result = collection.find(eq("email", email)).first();

        if (result != null && result.getString("senha").equals(senha)) {
            return new Aluno(
                result.getString("nome"),
                result.getString("email"),
                result.getString("telefone"),
                result.getString("ra"),
                result.getString("nomeFaculdade"),
                result.getString("senha"),
                result.getString("curso"),
                result.getString("orientador"),
                result.getString("linkedinGithub"),
                result.getString("areaDePesquisa")
            );
        }
        return null;
    }
}

