package com.example.dao;

import com.example.model.PesquisaAluno;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.List;

public class PesquisaAlunoDAO {

    private MongoDatabase database;

    public PesquisaAlunoDAO() {
        this.database = ConnectionFactory.getDatabase();
    }

    // Método para inserir um novo planeta
    public void inserirPlaneta(PesquisaAluno pesquisaAluno) {
        MongoCollection<Document> collection = database.getCollection("pesquisaAlunos");
        Document doc = new Document("nomePlaneta", pesquisaAluno.getNomePlaneta())
                .append("distanciaDaTerra", pesquisaAluno.getDistanciaDaTerra())
                .append("foto", pesquisaAluno.getFoto())
                .append("diametro", pesquisaAluno.getDiametro())
                .append("massa", pesquisaAluno.getMassa())
                .append("composicaoAtmosferica", pesquisaAluno.getComposicaoAtmosferica())
                .append("temperaturaMedia", pesquisaAluno.getTemperaturaMedia())
                .append("numeroDeLuas", pesquisaAluno.getNumeroDeLuas())
                .append("periodoOrbital", pesquisaAluno.getPeriodoOrbital())
                .append("tipoDeSuperficie", pesquisaAluno.getTipoDeSuperficie())
                .append("atividadeGeologica", pesquisaAluno.getAtividadeGeologica())
                .append("possibilidadeDeAgua", pesquisaAluno.getPossibilidadeDeAgua())
                .append("campoMagnetico", pesquisaAluno.getCampoMagnetico())
                .append("radiacao", pesquisaAluno.getRadiacao())
                .append("gravidade", pesquisaAluno.getGravidade())
                .append("caracteristicasEspeciais", pesquisaAluno.getCaracteristicasEspeciais())
                .append("tipo", pesquisaAluno.getTipo());

        collection.insertOne(doc);
    }
}
